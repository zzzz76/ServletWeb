package cc.openhome.model;

import java.util.*;

public class UserService {
    private AccountDAO accountDAO;
    private BlahDAO blahDAO;

    public UserService(AccountDAO accountDAO, BlahDAO blahDAO) {
        this.accountDAO = accountDAO;
        this.blahDAO = blahDAO;
    }

    public boolean isUserExisted(Account account) {
        return accountDAO.isUserExisted(account);
    }

        public void createUserData(Account account) {
            accountDAO.addAccount(account);
    }

    public boolean checkLogin(Account account) {
        Account storedAcct = accountDAO.getAccount(account);
        if (storedAcct != null && storedAcct.getPassword().equals(account.getPassword())) {
            return true;
        }
        return false;
    }

    private class DateComparator implements Comparator<Blah> {
        @Override
        public int compare(Blah b1, Blah b2) {
            return -b1.getDate().compareTo(b2.getDate());
        }
    }

    private DateComparator comparator = new DateComparator();

    public List<Blah> getBlahs(Blah blah) {
        List<Blah> blahs = blahDAO.getBlahs(blah);
        Collections.sort(blahs, comparator);
        return blahs;
    }

    public void addBlah(Blah blah) {
        blahDAO.addBlah(blah);
    }

    public void deleteBlah(Blah blah) {
        blahDAO.deleteBlah(blah);
    }
}