package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Write a program that reads a text file (inputLineNumbers.txt from the Resources - Exercises) and inserts line numbers in
front of each of its lines. The result should be written to another text file – output.txt.
 */
public class LineNumbersExercise {
    public static void main(String[] args) {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/";
        String fileInput = path + "inputLineNumbers.txt";
        String fileOut = path + "output.txt";

        try (BufferedReader read = Files.newBufferedReader(Paths.get(fileInput));
             BufferedWriter write = Files.newBufferedWriter(Paths.get(fileOut))) {

            String currentLine = read.readLine();
            int count = 1;
            while (currentLine != null) {

                String updatedLine = count + ". " + currentLine;
                write.write(updatedLine);
                write.newLine();
                count++;

                currentLine = read.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
