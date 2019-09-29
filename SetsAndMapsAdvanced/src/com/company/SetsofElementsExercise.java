package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/*
On the first line you are given the length of two sets n and m. On the next n + m lines there are n numbers that are
in the first set and m numbers that are in the second one. Find all non-repeating element that appears in both of
them, and print them in same order at the console:
Set with length n = 4: {1, 3, 5, 7}
Set with length m = 3: {3, 4, 5}
Set that contains all repeating elements -> {3, 5}
 */
public class SetsofElementsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = sizes[0] + sizes[1];

        LinkedHashSet<Integer> first = new LinkedHashSet<>();
        LinkedHashSet<Integer> second = new LinkedHashSet<>();
        LinkedHashSet<Integer> duplicates = new LinkedHashSet<>();

        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (first.contains(num) || second.contains(num)) {
                duplicates.add(num);
            }
            if (i < sizes[0]) {
                first.add(num);
            } else {
                second.add(num);
            }
        }

        for (Integer duplicate : duplicates) {
            System.out.print(duplicate + " ");
        }
    }
}
