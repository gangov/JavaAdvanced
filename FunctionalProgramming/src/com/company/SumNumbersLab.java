package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Write a program that reads one line of Integers separated by ", ". Print the count of the numbers and their sum.
Use a Function<String, Integer>
 */
public class SumNumbersLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> count = c -> c.size();

        Function<List<Integer>, Integer> totalFun = c -> {
            int total = 0;
            for (Integer integer : c) {
                total += integer;
            }
            return total;
        };

        System.out.println("Count = " + count.apply(numbers));
        System.out.println("Sum = " + totalFun.apply(numbers));
    }
}
