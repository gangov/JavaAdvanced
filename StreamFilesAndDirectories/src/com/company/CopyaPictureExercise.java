package com.company;

import java.io.*;

/*
Write a program that makes a copy of a .jpg file using FileInputStream, FileOutputStream, and byte[] buffer. Set the
name of the new file as picture-copy.jpg.
 */
public class CopyaPictureExercise {
    public static void main(String[] args) throws IOException {
        String path = "/Users/gangov/Downloads/woman.jpg";
//        File file = new File("/Users/gangov/Downloads/woman.jpg");
        try (FileInputStream inputStream = new FileInputStream(path);
             FileOutputStream outputStream = new FileOutputStream("/Users/gangov/Downloads/copy.jpg");
        ) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
