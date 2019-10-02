package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

        FileInputStream input = new FileInputStream("");

    }
}
