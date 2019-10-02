package com.company;

import java.io.*;

/*
Read the file named "input.txt" and write to another file every character's ASCII representation.
Write every space or new line as it is, e.g. as a space or a new line.
 */
public class CopyBytesLab {
    public static void main(String[] args) throws IOException {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/";
        String fileIn = path + "input.txt";
        String fileOut = path + "03.CopyBytesOutput.txt";

        InputStream inputStream = new FileInputStream(fileIn);
        OutputStream outputStream = new FileOutputStream(fileOut);

        int currentLetter = inputStream.read();
        while (currentLetter >= 0) {


            String representation = String.valueOf(currentLetter);

            if (currentLetter != ' ' && currentLetter != '\n') {
                for (int i = 0; i < representation.length(); i++) {
                    outputStream.write(representation.charAt(i));
                }
            } else {
                outputStream.write(currentLetter);
            }

            currentLetter = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
