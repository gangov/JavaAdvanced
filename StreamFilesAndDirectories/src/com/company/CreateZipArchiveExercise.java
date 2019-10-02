package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
Write a program that reads three .txt files and creates a zip archive named files.zip. Use FileOutputStream,
ZipOutputStream, and FileInputStream.
 */
public class CreateZipArchiveExercise {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/";
        String firstFile = path + "inputOne.txt";
        String secondFile = path + "inputTwo.txt";
        String thirdFile = path + "output.txt";
        String[] files = new String[]{firstFile, secondFile, thirdFile};

        try {

            byte[] buffer = new byte[1024];
            FileOutputStream output = new FileOutputStream("/Users/gangov/Desktop/files.zip");
            ZipOutputStream zipOut = new ZipOutputStream(output);

            for (String file1 : files) {
                File srcFile = new File(file1);
                FileInputStream input = new FileInputStream(srcFile);
                zipOut.putNextEntry(new ZipEntry(srcFile.getName()));

                int length;

                while ((length = input.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, length);
                }
                zipOut.closeEntry();
                input.close();
            }
            zipOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
