package com.company;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
Write a program that counts the occurrence of real numbers. The input is a single line with real numbers separated by
spaces. Print the numbers in the order of appearance. All numbers must be formatted to one digit after the decimal point.
 */
public class CountRealNumbersLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            if (!numbers.containsKey(input[i])) {
                numbers.put(input[i], 1);
            } else {
                numbers.put(input[i], numbers.get(input[i]) + 1);
            }
        }

//        for (Map.Entry<Double, Integer> numberAndOccurance : numbers.entrySet()) {
//            double number = numberAndOccurance.getKey();
//            int occurance = numberAndOccurance.getValue();
//            System.out.printf("%.1f -> %d%n", number, occurance);
//        }
        numbers.entrySet().stream().forEach(pair -> System.out.printf("%.1f -> %d%n", pair.getKey(), pair.getValue()));
    }
}
