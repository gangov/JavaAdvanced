package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Read the file named "input.txt" that is provided for this exercise and write all its content to a file while skipping
any punctuation. Skip the following symbols: ',', '.', '!', '?'.
 */
public class WritetoFileLab {
    public static void main(String[] args) throws IOException {
        String pathToFiles = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/";
        String inputFile = pathToFiles + "input.txt";
        String outputFile =  pathToFiles + "02.WriteToFileOutput.txt";

        InputStream inputStream = new FileInputStream(inputFile);
        OutputStream outputStream = new FileOutputStream(outputFile);
        Character[] avoidChars = new Character[]{',', '.', '!', '?'};
        Set<Character> hasThese = new HashSet<>();
        hasThese.addAll(Arrays.asList(avoidChars));

        int inputByte = inputStream.read();
        while (inputByte >= 0) {
            if (!hasThese.contains((char) inputByte)) {
                outputStream.write(inputByte);
            }
            inputByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
