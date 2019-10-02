package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Write a program that reads a text file (input.txt from the Resources - Exercises)  and prints on the console the sum of
the ASCII symbols of all characters inside of the file. Use BufferedReader in combination with FileReader.
 */
public class SumBytesExercise {
    public static void main(String[] args) {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/";
        String fileInput = path + "input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileInput))) {
            String currentLine = reader.readLine();
            long total = 0;
            while (currentLine != null) {
                for (char c : currentLine.toCharArray()) {
                    total += c;
                }
                currentLine = reader.readLine();
            }
            System.out.println(total);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
