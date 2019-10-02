package com.company;

import java.io.*;

/*
Read the file provided, named "input.txt" and write to another file all lines which number is divisible by 3. Line
numbers start from one.
 */
public class WriteEveryThirdLineLab {
    public static void main(String[] args) throws IOException {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/FilesToUse/";
        String fileIn = path + "input.txt";
        String fileOut = path + "05.WriteEveryThirdLineOutput.txt";

        BufferedReader inputStream = new BufferedReader(new FileReader(fileIn));
        PrintWriter outputStream = new PrintWriter(new FileWriter(fileOut));

        int count = 1;
        String line = inputStream.readLine();

        while (line != null) {
            if (count % 3 == 0) {
                outputStream.println(line);
            }
            count++;
            line = inputStream.readLine();
        }

        inputStream.close();
        outputStream.close();

    }
}
