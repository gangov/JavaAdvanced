package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns like the one in
the examples below.
Rows define the first and the last letter: row 0  ‘a’, row 1  ‘b’, row 2  ‘c’, …
Columns + rows define the middle letter:
column 0, row 0  ‘a’, column 1, row 0  ‘b’, column 2, row 0  ‘c’, …
column 0, row 1  ‘b’, column 1, row 1  ‘c’, column 2, row 1  ‘d’, …
Input:
1. The numbers r and c stay at the first line at the input.
2. r and c are integers in the range [1…26].
3. r + c ≤ 27
 */
public class MatrixofPalindromesExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];

        matrixBuilder(matrix);

        for (String[] ints : matrix) {
            for (String anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static String[][] matrixBuilder(String[][] matrix) {
        StringBuilder enter = new StringBuilder("***");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                enter.setCharAt(0, (char) ((char) row + 97));
                enter.setCharAt(1, (char) ((char) row + col + 97));
                enter.setCharAt(2, (char) ((char) row + 97));
                matrix[row][col] = String.valueOf(enter);
            }
        }

        return matrix;
    }
}
