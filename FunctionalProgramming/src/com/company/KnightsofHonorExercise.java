package com.company;

import java.util.Scanner;
import java.util.function.Consumer;

/*
Write a program that reads a collection of names as strings from the console and then appends “Sir” in front of every
name and prints it back onto the console. Use a Consumer<T>.
 */
public class KnightsofHonorExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> print = s -> System.out.println("Sir " + s);

        for (String s : input) {
            print.accept(s);
        }
    }
}
