package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads N integers from the console and reverses them using a stack. Use the ArrayDeque<Integer>
class. Just put the input numbers in the stack and pop them. */
public class ReverseNumberswithaStackExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> nums = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(nums::push);

        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
