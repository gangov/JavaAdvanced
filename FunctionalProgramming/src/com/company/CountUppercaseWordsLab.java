package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/*
Write a program that reads one line of text from the console. Print the count of words that start with a Uppercase
letter, after that print all these words in the same order, like you found them in the text.
Use a Predicate<String>
 */
public class CountUppercaseWordsLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        int count = 0;
        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        ArrayList<String> listUpperCaseWords = new ArrayList<>();

        for (String word : words) {
            if (isUpperCase.test(word)) {
                count++;
                listUpperCaseWords.add(word);
            }
        }

        System.out.println(count);
        for (String listUpperCaseWord : listUpperCaseWords) {
            System.out.println(listUpperCaseWord);
        }
    }
}
