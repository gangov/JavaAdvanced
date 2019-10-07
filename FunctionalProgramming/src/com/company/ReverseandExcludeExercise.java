package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/*
Write a program that reverses a collection and removes elements that are divisible by a given integer n.
 */
public class ReverseandExcludeExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int numToDecide = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> filter = n -> n % numToDecide != 0;

        UnaryOperator<List<Integer>> removeNums = newList -> newList.stream()
                .filter(filter)
                .collect(Collectors.toList());

        nums = removeNums.apply(nums);

        Collections.reverse(nums);
        System.out.println(nums.toString().replaceAll("[\\[\\],]",""));
    }
}
