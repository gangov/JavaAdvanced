package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Write a program that reads the contents of two text files (inputOne.txt, inputTwo.txt from Resources Exercises) and
merges them together into a third one.
 */
public class MergeTwoFilesExercise {
    public static void main(String[] args) {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/";
        String firstFile = path + "inputOne.txt";
        String secondFile = path + "inputTwo.txt";
        String thirdFile = path + "output.txt";

        try (BufferedReader readOne = Files.newBufferedReader(Path.of(firstFile));
             BufferedReader readTwo = Files.newBufferedReader(Path.of(secondFile));
             BufferedWriter writeToThree = Files.newBufferedWriter(Path.of(thirdFile))) {

            String currentLine = readOne.readLine();
            while (currentLine != null) {
                writeToThree.write(currentLine);
                writeToThree.newLine();
                currentLine = readOne.readLine();
            }

            String secondCurrent = readTwo.readLine();
            while (secondCurrent != null) {
                writeToThree.write(secondCurrent);
                writeToThree.newLine();

                secondCurrent = readTwo.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
