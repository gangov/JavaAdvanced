package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/*
You have an empty sequence, and you will be given N commands. Each command is one of the following types:
"1 X" - Push the element X into the stack.
"2" - Delete the element present at the top of the stack.
"3" - Print the maximum element in the stack.
 */
public class MaximumElementExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            int[] command = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            switch (command[0]) {
                case 1:
                    numbers.push(command[1]);
                    break;
                case 2:
                    numbers.pop();
                    break;
                case 3:
                    int maxNum = Integer.MIN_VALUE;
                    for (Integer number : numbers) {
                        if (number > maxNum) {
                            maxNum = number;
                        }
                    }
                    System.out.println(maxNum);
                    break;
            }
        }
    }
}
