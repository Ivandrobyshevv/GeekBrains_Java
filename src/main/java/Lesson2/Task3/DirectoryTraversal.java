package Lesson2.Task3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;


public class DirectoryTraversal {
    public static void main(String[] args) {

        File currentDir = new File("/Users/ivan/IdeaProjects/untitled/.idea");
        displayAllFilesDirectories(currentDir);

    }
    public static void displayAllFilesDirectories(File dir) {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory: " + file.getCanonicalPath());
                } else {
                    String name = file.getName();
                    String foramt = getFileExtension(name);
                    long lastModified = file.lastModified();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

                    System.out.println("file: " + name + ", размер файла: " + file.length() + " byte, дата изменения: " + sdf.format(new Date(lastModified))
                    + "Расширение файла: " + foramt);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getFileExtension(String mystr) {
        int index = mystr.indexOf('.');
        return index == -1? null : mystr.substring(index);
    }
}
