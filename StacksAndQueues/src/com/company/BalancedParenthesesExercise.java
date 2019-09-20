package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
Given a sequence consisting of parentheses, determine whether the expression is balanced. A sequence of parentheses is
balanced if every open parenthesis can be paired uniquely with a closed parenthesis that occurs after the former.
Also, the interval between them must be balanced. You will be given three types of parentheses: (, {, and [.
 */
public class BalancedParenthesesExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ArrayDeque<Character> open = new ArrayDeque<>();

        boolean isEqual = true;

        for (int i = 0; i < line.length(); i++) {
            char bracket = line.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                open.push(bracket);
            } else {
                if (open.isEmpty()) {
                    isEqual = false;
                    break;
                }
                char now = open.pop();
                if (bracket == ')' && now != '(') {
                    isEqual = false;
                    break;
                } else if (bracket == ']' && now != '[') {
                    isEqual = false;
                    break;
                } else if (bracket == '}' && now != '{') {
                    isEqual = false;
                    break;
                }
            }
        }



        if (isEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
