package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Write a program that reads a text file (input.txt from the Resources - Exercises) and prints on the console the sum of
the ASCII symbols of each of its lines. Use BufferedReader in combination with FileReader.
 */
public class SumLinesExercise {
    public static void main(String[] args) {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/";
        String fileInput = path + "input.txt";

        try (
                BufferedReader inputReader = Files.newBufferedReader(Paths.get(fileInput))
        ) {
            String currentLine = inputReader.readLine();
            while (currentLine != null) {
                long total = 0;
                for (char c : currentLine.toCharArray()) {
                    total += c;
                }
                System.out.println(total);
                currentLine = inputReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
