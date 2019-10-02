package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
Write a program that reads a list of words from the file words.txt (from the Resources - Exercises) and finds how many
times each of the words is contained in another file text.txt (from the Resources – Exercises). Matching should be
case-insensitive.
Write the results in file results.txt. Sort the words by frequency in descending order.
 */
public class WordCountExercise {
    public static void main(String[] args) throws IOException {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/";
        String criteria = path + "words.txt";
        String lookIn = path + "text.txt";

        LinkedHashMap<String, Integer> occurances = new LinkedHashMap<>();

        BufferedReader lookingIn = Files.newBufferedReader(Path.of(lookIn));
        List<String> entireStringLooking = new ArrayList<>();

        String currentLine = lookingIn.readLine();
        while (currentLine != null) {

            entireStringLooking.add(currentLine);

            currentLine = lookingIn.readLine();
        }

        BufferedReader searchingWith = Files.newBufferedReader(Path.of(criteria));
        List<String> findList = new ArrayList<>();

        String currentLineFind = searchingWith.readLine();
        while (currentLineFind != null) {

            findList.add(currentLineFind);

            currentLineFind = searchingWith.readLine();
        }


        String stringFile = String.join(" ", entireStringLooking);
        String[] arrayFile = stringFile.split("[\\s+.,\\-]");
        String mumbJumbo = String.join(" ", findList);
        String[] arrayCriteria = mumbJumbo.split(" ");

        for (String allLetters : arrayFile) {
            for (String search : arrayCriteria) {
                if (search.equals(allLetters)) {
                    occurances.putIfAbsent(search, 0);
                    occurances.put(search, occurances.get(search) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> wordsAndCount : occurances.entrySet()) {
            String word = wordsAndCount.getKey();
            Integer count = wordsAndCount.getValue();
            System.out.println(String.format("%s - %d", word, count));
        }
    }
}
