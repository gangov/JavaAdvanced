package com.company;
/*
Create a simple calculator that can evaluate simple expressions that will not hold any operator different from addition
and subtraction. There will not be parentheses or operator precedence. Solve the problem using a Stack.
 */
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculatorLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> digits = new ArrayDeque<>(Arrays.asList(input));

        int total = 0;
        while (digits.size() > 1) {
            int first = Integer.parseInt(digits.pop());
            String operation = digits.pop();
            int second = Integer.parseInt(digits.pop());

            if (operation.equals("+")) {
                total = first + second;
                digits.push(String.valueOf(total));
            } else {
                total = first - second;
                digits.push(String.valueOf(total));
            }
        }
        System.out.println(total);
    }
}
