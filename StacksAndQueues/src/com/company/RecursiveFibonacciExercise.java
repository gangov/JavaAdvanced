package com.company;

import java.util.Scanner;

/*
Each member of the Fibonacci sequence is calculated from the sum of the two previous members. The first two elements
are 1, 1. Therefore the sequence goes as 1, 1, 2, 3, 5, 8, 13, 21, 34…
The following sequence can be generated with an array, but that’s easy, so your task is to implement it recursively.
If the function getFibonacci(n) returns the nth Fibonacci number, we can express it using
getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2).
However, this will never end and in a few seconds a Stack Overflow Exception is thrown. In order for the recursion to
stop it has to have a "bottom". The bottom of the recursion is getFibonacci(1), and should return 1. The same goes for
getFibonacci(0).
 */
public class RecursiveFibonacciExercise {

    static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1];

        long fibo = calcFibo(n);

        System.out.println(fibo);
    }

    private static long calcFibo(int n) {
        if (n < 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = calcFibo(n - 1) + calcFibo(n - 2);
    }
}
