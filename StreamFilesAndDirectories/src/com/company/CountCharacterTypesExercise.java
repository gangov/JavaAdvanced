package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/*
Write a program that reads a list of words from the file (input.txt from the Resources - Exercises)  and finds the count
of vowels, consonants and punctuation marks. Assume that:
a, e, i, o, u are vowels, only lower case
All others are consonants
Punctuation marks are (!,.?)
Do not count whitespace.
Write the results to another file – output.txt.
Vowels: 41
Consonants: 72
Punctuation: 6
 */
public class CountCharacterTypesExercise {
    public static void main(String[] args) {
        String path = "/Users/gangov/IdeaProjects/JavaAdvanced/StreamFilesAndDirectories/src/ExerciseFilesToUse/Exercises-Resources/";
        String fileIn = path + "input.txt";
        String fileOut = path + "output.txt";

        HashMap<String, Integer> types = new HashMap<>();
        types.put("Vowels", 0);
        types.put("Consonants", 0);
        types.put("Punctuations", 0);

        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(fileIn));
        ) {

            String currentLine = reader.readLine();
            while (currentLine != null) {

                char[] allSymbols = currentLine.toCharArray();

                for (int i = 0; i < allSymbols.length; i++) {
                    if ((allSymbols[i] >= 65 && allSymbols[i] <= 90) || (allSymbols[i] >= 97 && allSymbols[i] <= 122)) {
                        if (allSymbols[i] == 'a' || allSymbols[i] == 'e' || allSymbols[i] == 'i' || allSymbols[i] == 'o'
                                || allSymbols[i] == 'u') {
                            types.put("Vowels", types.get("Vowels") + 1);
                        } else {
                            types.put("Consonants", types.get("Consonants") + 1);
                        }
                    } else if (allSymbols[i] >= 48 && allSymbols[i] <= 57) {
                        types.put("Consonants", types.get("Consonants") + 1);
                    } else if (allSymbols[i] != ' ' || allSymbols[i] == ',' || allSymbols[i] == '.' || allSymbols[i] == 39 || allSymbols[i] == '-') {
                        types.put("Punctuations", types.get("Punctuations") + 1);
                    }
                }
                currentLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileOut));
        ) {
            for (Map.Entry<String, Integer> stringListEntry : types.entrySet()) {
                writer.write(String.format("%s: %d", stringListEntry.getKey(), stringListEntry.getValue()));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
