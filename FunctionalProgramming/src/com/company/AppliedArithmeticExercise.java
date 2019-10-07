package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
On the first line you are given a list of numbers. On the next lines you are passed different commands that you need to
apply to all numbers in the list: "add" -> adds 1; "multiply" -> multiplies by 2; "subtract" -> subtracts 1; "print" ->
prints all numbers on a new line. The input will end with an "end" command, after which you need to print the result.
 */
public class AppliedArithmeticExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        Function<Integer, Integer> add = num -> num + 1;
        Function<Integer, Integer> multiply = num -> num * 2;
        Function<Integer, Integer> subtract = num -> num - 1;

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = numbers.stream().map(add).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers = numbers.stream().map(subtract).collect(Collectors.toList());
                    break;
                case "multipy":
                    numbers = numbers.stream().map(multiply).collect(Collectors.toList());
                    break;
                case "print":
                    System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
                    break;
            }
            command = scanner.nextLine();
        }


    }

}
