package com.company;

import java.io.*;
import java.util.Scanner;

/*
Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file. A
valid integer is surrounded with white spaces.
 */
public class ExtractIntegersLab {
    public static void main(String[] args) throws IOException {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/";
        String fileIn = path + "input.txt";
        String fileOut = path + "04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(fileIn));
        PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileOut));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                outputStream.println(scanner.nextInt());
            }
            scanner.next();
        }

        scanner.close();
        outputStream.close();
    }
}
