package cc.openhome.model;

import java.io.*;

public class AccountDAOImpl implements AccountDAO {

    private String USERS;

    public AccountDAOImpl(String USERS) {
        this.USERS = USERS;
    }

    @Override
    public boolean isUserExisted(Account account) {
        for (String file : new File(USERS).list()) {
            if (file.equals(account.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addAccount(Account account) {
        try {
            File userhome = new File(USERS + "/" + account.getName());
            userhome.mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(userhome
                    + "/profile"));
            writer.write(account.getEmail() + "\t" + account.getPassword());
            writer.close();
        } catch (IOException e) {
            // 日志打印
        }

    }

    @Override
    public Account getAccount(Account account) {
        try {
            for (String file : new File(USERS).list()) {
                if (file.equals(account.getName())) {
                    BufferedReader reader = new BufferedReader(new FileReader(
                            USERS + "/" + file + "/profile"));
                    String passwd = reader.readLine().split("\t")[1];
                    Account storedAcct = new Account();
                    storedAcct.setName(file);
                    storedAcct.setPassword(passwd);
                    return storedAcct;
                }
            }
        } catch (IOException e) {
            // 日志打印
        }
        return null;
    }
}
