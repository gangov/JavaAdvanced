package com.company;

import java.util.Scanner;
import java.util.function.Consumer;

/*
Write a program that reads a collection of strings, separated by one or more whitespaces, from the console and then
prints them onto the console. Each string should be printed on a new line. Use a Consumer<T>.
 */
public class ConsumerPrintExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> printer = System.out::println;

        for (String s : input) {
            printer.accept(s);
        }
    }
}
