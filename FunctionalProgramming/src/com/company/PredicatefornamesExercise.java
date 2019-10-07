package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
Write a predicate. Its goal is to check a name for its length and to return true if the names length is less or equal
the passed integer. You will be given an integer that represents the length you have to use. On the second line you will
be given a string array with some names. Print the names, passing the condition in the predicate.
 */
public class PredicatefornamesExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenToUse = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> checkLen = name -> name.length() <= lenToUse;

        names.stream().filter(checkLen).forEach(System.out::println);
    }
}
