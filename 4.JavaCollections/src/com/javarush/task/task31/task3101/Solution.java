package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    private static List<File> fileList = new ArrayList<>();
    private static File mainFile;

    public static void main(String[] args)
    {
        /*File path = new File(args[0]);
        mainFile = new File(args[1]);*/

        File path = new File("D:/test/");
        mainFile = new File("D:/testallFilesContent.txt");

        File newFile = new File(mainFile.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(mainFile, newFile);
        mainFile = newFile;

        try (FileOutputStream fileOutputStream = new FileOutputStream(mainFile)) {

            removeFile(path);
            Collections.sort(fileList, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });


            for (int i = 0; i < fileList.size(); i++) {
                if (i > 0)
                    fileOutputStream.write(System.lineSeparator().getBytes());

                FileInputStream fileInputStream = new FileInputStream(fileList.get(i));
                byte[] buffer = new byte[50];
                while (fileInputStream.available() > 0) {
                    int length = fileInputStream.read(buffer);
                    fileOutputStream.write(buffer, 0, length);
                }
                fileInputStream.close();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void removeFile(File file)
    {
        if (file.isDirectory())
        {
            for (File f : file.listFiles())
                removeFile(f);

            if (file.listFiles().length == 0)
                FileUtils.deleteFile(file);
        } else
        {
            if (!file.equals(mainFile))
            {
                if (file.length() > 50)
                    FileUtils.deleteFile(file);
                else
                    fileList.add(file);
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
