package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

/*
Write a program that reads one line of Double prices separated by ", ". Print the prices with added VATs for all of
them. Format them to the 2nd digit after the decimal point. The order of the prices must remain the same.
Use an UnaryOperator<Double>
 */
public class AddVATLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        UnaryOperator<Double> sumIt = num -> num * 1.2;
        System.out.println("Prices with VAT:");
        for (double number : numbers) {
            System.out.printf("%.2f%n", sumIt.apply(number));
        }
    }
}
