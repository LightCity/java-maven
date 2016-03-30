package fuckjava;

import java.io.*;
import java.util.zip.*;

import org.apache.commons.io.FileUtils;

public class UnzipTest {
    
    public static void main(String[] args) throws IOException {
        File oldf = new File("/tmp/haha");
        oldf.mkdirs();
        System.out.println(oldf.exists());
        
        File newf = new File("/tmp/aaaa");
        oldf.renameTo(newf);
        System.out.println(oldf.exists());
        
       // FileUtils.deleteDirectory(f);
        
        //main1();
    }
    
    /**
     * 删除目录
     * @param directory
     * @return 如果目录已经消失（被删除或原本就不存在），则返回true。否则返回false
     */
    public static boolean deleteDirectory(File directory) {
        if (directory == null) {
            return true;
        }
        if (!directory.exists()) {
            return true;
        }
        if (!directory.isDirectory()) {
            return true;
        }
        
        boolean allOk = true;
        File[] listFiles = directory.listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                deleteDirectory(file);
            } else {
                if (!file.delete()) {
                    allOk = false;
                }
            }
        }
        return allOk;
    }
    

    public static void main1() throws IOException {
        ZipInputStream zis = null;
        FileOutputStream fos = null;
        try {
            String zipPath = "/tmp/归档.zip";
            zis = new ZipInputStream(new FileInputStream(zipPath));
    
            String basePath = "/tmp/";
            
            byte[] bytes = new byte[4096];
            ZipEntry en;
            while ( (en = zis.getNextEntry()) != null ) {
                File tmpFile = new File(basePath, en.getName());
                System.out.println("entry: " + tmpFile.getAbsolutePath());
                if (en.isDirectory()) {
                    tmpFile.mkdirs();
                    continue;
                }
                File parentFile = tmpFile.getParentFile();
                System.out.println("parentFile=" + parentFile + ", result=" + parentFile.mkdirs() );
                tmpFile.createNewFile();
                fos = new FileOutputStream(tmpFile);
                while ( zis.read(bytes) != -1 ) {
                    fos.write(bytes);
                }
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (zis != null) {
                zis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

}
