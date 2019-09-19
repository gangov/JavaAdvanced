package com.company;
/*
Create a simple program that can convert a decimal number to its binary representation. Implement an elegant solution
using a Stack. Print the binary representation back at the terminal.
 */
import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimaltoBinaryConverterLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayDeque<Integer> binary = new ArrayDeque<>();

        if (num == 0) {
            System.out.println(0);
        } else {
            while (num > 0) {
                int temp = num % 2;
                binary.push(temp);
                num /= 2;
            }
        }

        for (Integer integer : binary) {
            System.out.print(integer);
        }
    }
}
