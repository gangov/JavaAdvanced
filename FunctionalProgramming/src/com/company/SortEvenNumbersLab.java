package com.company;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Write a program that reads one line of Integers separated by ", ".
Print the even numbers
Sort them in ascending order
Print them again.
Use 2 Lambda Expresions to do so.
 */
public class SortEvenNumbersLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsall = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        numsall.removeIf(num -> num % 2 != 0);

        for (int i = 0; i < numsall.size(); i++) {
            if (i == numsall.size() - 1) {
                System.out.println(numsall.get(i));
            } else {
                System.out.print(numsall.get(i)  + ", ");
            }
        }

        numsall.sort((e1, e2) -> { return e1.compareTo(e2);});

        for (int i = 0; i < numsall.size(); i++) {
            if (i == numsall.size() - 1) {
                System.out.println(numsall.get(i));
            } else {
                System.out.print(numsall.get(i)  + ", ");
            }
        }
    }
}
