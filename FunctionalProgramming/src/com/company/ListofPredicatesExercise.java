package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
Find all numbers in the range 1..N that are divisible by the numbers of a given sequence. Use predicates.
 */
public class ListofPredicatesExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> divisible = num -> {
            boolean print = true;

            for (Integer number : numbers) {
                if (num % number != 0) {
                    print = false;
                    break;
                }
            }
            return print;
        };

        for (int i = 1; i <= range; i++) {
            if (divisible.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
