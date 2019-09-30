package com.company;

import java.util.*;
import java.util.stream.Collectors;

/*
Write a program that:
Reads from console number of students for a track
Reads on pair of rows:
First line is the name of student
Second line is his score for different number of courses
Print on console “{name} is graduated with {average scores)”
 */
public class AcademyGraduationLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            studentsAndGrades.putIfAbsent(name, grades);

        }

//        for (Map.Entry<String, List<Double>> entrySet : studentsAndGrades.entrySet()) {
//            String name = entrySet.getKey();
//            List<Double> grades = entrySet.getValue();
////            double avg = grades.stream().mapToDouble(grade -> grade).average().getAsDouble();
//            double avg = 0;
//            for (Double grade : grades) {
//                avg += grade;
//            }
//            double finalAvg = avg / grades.size();
//            System.out.println(name + " is graduated with " + finalAvg);
//        }

        studentsAndGrades.entrySet().stream().forEach(pair -> {
            System.out.printf("%s is graduated with ", pair.getKey());
            double total = 0;
            for (Double aDouble : pair.getValue()) {
                total += aDouble;
            }
            double avg = total / pair.getValue().size();
            System.out.println(avg);
        });
    }
}
