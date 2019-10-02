package com.company;

import java.io.File;

/*
Write a program that traverses a folder and calculates its size in bytes. Use Folder Exercises Resources in Resources.
 */
public class GetFolderSizeExercise {
    public static void main(String[] args) {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/Exercises Resources";
        String firstFile = path + "input.txt";

        File file = new File(path);

        System.out.println("Folder size: " + folderSize(file));
    }

    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }

}
