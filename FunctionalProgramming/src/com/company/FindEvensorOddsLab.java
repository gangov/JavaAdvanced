package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/*
You are given a lower and an upper bound for a range of integer numbers. Then a command specifies if you need to list
all even or odd numbers in the given range. Use predicates that need to be passed to a method.
 */
public class FindEvensorOddsLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bottom = numbers[0];
        int top = numbers[1];

        String condition = scanner.nextLine();

        IntPredicate filter = null;
        if (condition.equals("odd")) {
            filter = n -> n % 2 != 0;
        } else {
            filter = n -> n % 2 == 0;
        }

        IntStream.range(bottom, top + 1).filter(filter).forEach(s -> System.out.print(s + " "));
    }
}
