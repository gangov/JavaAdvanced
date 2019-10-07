package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Write a custom comparator that sorts all even numbers before all odd ones in ascending order. Pass it to an
Arrays.sort() function and print the result.
 */
public class CustomComparatorExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparing = (first, second) -> {
            int compare;

            if (first % 2 == 0 && second % 2 != 0) {
                compare = -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                compare = 1;
            } else {
                compare = first - second;
            }

            return compare;
        };

        numbers.sort(comparing);

        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
