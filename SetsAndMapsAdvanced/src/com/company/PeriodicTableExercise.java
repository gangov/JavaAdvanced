package com.company;

import java.util.Scanner;
import java.util.TreeSet;

/*
You are given an n number of chemical compounds. You need to keep track of all chemical elements used in the compounds
and at the end print all unique ones in ascending order:
 */
public class PeriodicTableExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            String[] toAdd = scanner.nextLine().split(" ");
            for (int j = 0; j < toAdd.length; j++) {
                elements.add(toAdd[j]);
            }
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
