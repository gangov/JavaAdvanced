package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// TODO: 28.09.19 make it better
/*
Write a program, which reads the name of a student and their grades and adds them to the student record, then prints
grades along with their average grade – ordered the output by the names of the students.
Input
On the first line N – the number of students, then on the next N lines student name with grade.
 */
public class AverageStudentsGradesLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!studentsAndGrades.containsKey(name)) {
                studentsAndGrades.put(name, new ArrayList<>());
                studentsAndGrades.get(name).add(grade);
            } else {
                studentsAndGrades.get(name).add(grade);
            }
        }

        for (Map.Entry<String, ArrayList<Double>> nameAndGrades : studentsAndGrades.entrySet()) {
            String name = nameAndGrades.getKey();
            double average = nameAndGrades.getValue().stream().mapToDouble(i -> i).average().getAsDouble();

            System.out.print(name + " -> ");
            nameAndGrades.getValue().forEach(num -> System.out.printf("%.2f ", num));
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
