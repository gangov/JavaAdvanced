package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Write a program that reads a text file (input.txt from the Resources - Exercises)  and changes the casing of all letters
to upper. Write the output to another file (output.txt).
 */
public class AllCapitalsExercise {
    public static void main(String[] args) {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/";
        String fileInput = path + "input.txt";
        String fileOut = path + "output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileInput));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileOut))
        ) {

            String currentLine = reader.readLine();
            while (currentLine != null) {
                char[] allSymbols = currentLine.toCharArray();

                for (int i = 0; i < allSymbols.length; i++) {
                    if (allSymbols[i] > 96 && allSymbols[i] < 123 && allSymbols[i] != '\n') {
                        allSymbols[i] -= 32;
                    }
                }
                writer.write(allSymbols);
                writer.newLine();
                currentLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
