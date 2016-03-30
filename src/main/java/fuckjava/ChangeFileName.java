package fuckjava;

public class ChangeFileName {

    public static void main(String[] args) {
        char ch = (char) 19886;
        System.out.println(ch);
    }
}



/*

        String path = "/Volumes/Eaget1/电影/";
        
        File dir = new File(path);
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                String prefix = "[电影天堂www.dygod.com].";
                if (fileName.startsWith(prefix)) {
                    String newName = path + fileName.substring(prefix.length());
                    System.out.println(newName);
                    file.renameTo(new File(newName));
                }
            }
        }

*/