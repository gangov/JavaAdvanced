package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes (the binary
representation of the ASCII code for each character) separated by a single comma.
 */
public class ReadFileLab {
    public static void main(String[] args) throws IOException {
        String pathToInput = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/";
        String inputFile = pathToInput + "input.txt";

        InputStream inputStream = new FileInputStream(inputFile);
        int theByte = inputStream.read();
        try {
            while (theByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(theByte));
                theByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
    }
}
