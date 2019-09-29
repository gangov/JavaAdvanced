package com.company;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
Write a program that reads some text from the console and counts the occurrences of each character in it. Print the
results in alphabetical (lexicographical) order.
 */
public class CountSymbolsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<Character, Integer> text = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            text.putIfAbsent(input.charAt(i), 0);
            text.put(input.charAt(i), text.get(input.charAt(i)) + 1);
        }
        for (Map.Entry<Character, Integer> charAndOccurances : text.entrySet()) {
            char letter = charAndOccurances.getKey();
            int occurances = charAndOccurances.getValue();

            System.out.printf("%c: %d time/s%n", letter ,occurances);
        }
    }
}
