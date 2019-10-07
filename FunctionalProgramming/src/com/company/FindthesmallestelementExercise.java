package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Write a program which is using  a custom function (written by you) to find the smallest integer in a sequence of
integers. The input could have more than one space. Your task is to collect the integers from the console, find the
smallest one and print its index (if more than one such elements exist, print the index of the rightmost one).
Hints
Use a Function<List<Integer>, Integer> or something similar.
 */
public class FindthesmallestelementExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int smallest = numbers.stream().mapToInt(e -> e).min().getAsInt();

        System.out.println(numbers.lastIndexOf(smallest));
    }
}
