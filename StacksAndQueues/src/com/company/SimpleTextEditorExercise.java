package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
You are given an empty text. Your task is to implement 4 types of commands related to manipulating the text:
"1 [string]" - appends [string] to the end of the text
"2 [count]" - erases the last [count] elements from the text
"3 [index]" - returns the element at position [index] from the text
"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation

Input
The first line contains N, the number of operations, where 1 ≤ N ≤ 105
Each of the following N lines contains the name of the operation, followed by the command argument, if any, separated
by space in the following format "command argument".
The length of the text will not exceed 1000000
All input characters are English letters
It is guaranteed that the sequence of input operation is possible to perform
 */
public class SimpleTextEditorExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        String input = "";
        ArrayDeque<String> memory = new ArrayDeque<>(); //Queue

        while (number-- > 0) {
            String[] commands = scanner.nextLine().split("\\s");
            String firstPart = commands[0];
            String operand = "";
            switch (firstPart) {
                case "1":
                    operand = commands[1];
                    memory.push(input);
                    input += operand;
                    break;
                case "2":
                    operand = commands[1];
                    memory.push(input);
                    int count = Integer.parseInt(operand);
                    input = input.substring(0, input.length() - count);
                    break;
                case "3":
                    operand = commands[1];
                    int index = Integer.parseInt(operand) - 1;
                    System.out.println(input.charAt(index));
                    break;
                case "4":
                    input = memory.pop();
                    break;

            }
        }
    }
}
