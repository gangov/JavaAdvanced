package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
Write a program that reads an integer N on the first line. And on next N lines read pairs of "[name], [age]". Then read
three more lines with:
Condition - "younger" or "older"
Age - Integer
Format - "name", "age" or "name age"
Depending on the condition, print the pairs in the right format.
Don’t use any build-in functionality. Write your own methods.
 */
public class FilterbyAgeLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(condition, ageLimit);

        Consumer<Map.Entry<String, Integer>> printer = getPrinter(format);

        people.entrySet()
                .stream()
                .filter(e -> filter.test(e.getValue()))
                .forEach(e -> printer.accept(e));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> result;

        if (format.equals("name")) {
            result = e -> System.out.println(e.getKey());
        } else if (format.equals("age")) {
            result = e -> System.out.println(e.getValue());
        } else {
            result = e -> System.out.println(e.getKey() + " - " + e.getValue());
        }

        return result;
    }

    private static Predicate<Integer> getPredicate(String condition, int ageLimit) {
        Predicate<Integer> result;
        if (condition.equals("younger")) {
            result = n -> n <= ageLimit;
        } else {
            result = n -> n >= ageLimit;
        }

        return result;
    }
}
