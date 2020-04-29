package cc.openhome.model;

import java.util.*;
import java.io.*;

public class BlahDAOImpl implements BlahDAO{

    private String USERS;

    public BlahDAOImpl(String USERS) {
        this.USERS = USERS;
    }

    private class TxtFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".txt");
        }
    }

    private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();

    @Override
    public List<Blah> getBlahs(Blah blah) {
        try {
            File border = new File(USERS + "/" + blah.getUsername());
            String[] txts = border.list(filenameFilter);
            List<Blah> blahs = new ArrayList<Blah>();
            for(String txt : txts) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(USERS + "/" + blah.getUsername() + "/" + txt), "UTF-8"));
                String text = null;
                StringBuilder builder = new StringBuilder();
                while((text = reader.readLine()) != null) {
                    builder.append(text);
                }
                Date date = new Date(Long.parseLong(txt.substring(0, txt.indexOf(".txt"))));
                blahs.add(new Blah(blah.getUsername(), date, builder.toString()));
                reader.close();
            }
            return blahs;
        } catch (IOException e) {

        }
        return null;
    }

    @Override
    public void addBlah(Blah blah) {
        try {
            String file = USERS + "/" + blah.getUsername() + "/" + blah.getDate().getTime() + ".txt";
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            writer.write(blah.getTxt());
            writer.close();
        } catch (IOException e) {

        }
    }

    @Override
    public void deleteBlah(Blah blah) {
        File file = new File(USERS + "/" + blah.getUsername() + "/" + blah.getDate().getTime() + ".txt");
        if(file.exists()) {
            file.delete();
        }
    }
}
