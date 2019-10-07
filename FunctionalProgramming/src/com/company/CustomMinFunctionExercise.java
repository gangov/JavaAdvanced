package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/*
Write a simple program that reads a set of numbers from the console and finds the smallest of the numbers using a simple
Function<Integer[], Integer> .
 */
public class CustomMinFunctionExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> findMin = findLowestNum(input);

        System.out.println(findMin.apply(input));

    }

    private static Function<int[], Integer> findLowestNum(int[] input) {
        return num -> {
            int smallest = Integer.MAX_VALUE;

            for (int i = 0; i < input.length; i++) {
                if (input[i] < smallest) {
                    smallest = input[i];
                }
            }
            return smallest;
        };
    }
}
