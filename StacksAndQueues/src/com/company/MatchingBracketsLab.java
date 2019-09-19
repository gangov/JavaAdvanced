package com.company;
/*
We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
Print the result back at the terminal.
 */
import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBracketsLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> result = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                result.push(i);
            } else if (input.charAt(i) == ')') {
                int startFrom = result.pop();
                String results = input.substring(startFrom, i + 1);
                System.out.println(results);
            }
        }
    }
}
