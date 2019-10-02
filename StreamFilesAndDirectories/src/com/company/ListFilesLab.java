package com.company;

import java.io.File;

/*
You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytes) of
all files that are placed directly in it (do not include files in nested folders).
 */
public class ListFilesLab {
    public static void main(String[] args) {
        File file = new File("/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (!file1.isDirectory()) {
                        System.out.println(String.format("%s: [%s]", file1.getName(), file1.length()));
                    }
                }
            }
        }
    }
}
