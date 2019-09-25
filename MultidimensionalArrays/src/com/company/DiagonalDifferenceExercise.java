package com.company;

import java.util.Arrays;
import java.util.Scanner;
/*
Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).
 */
public class DiagonalDifferenceExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        createMatirx(matrix, scanner);
        int first = firstDiagonalTotal(matrix);
        int second = secondDiagonalTotal(matrix);

        System.out.println(Math.abs(first - second));
    }

    private static int secondDiagonalTotal(int[][] matrix) {
        int total = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[row].length) {
            total += matrix[row][col];
            row--;
            col++;
        }
        return total;
    }

    private static int firstDiagonalTotal(int[][] matrix) {
        int total = 0;
        int row = 0;
        int col = 0;
        while (row < matrix.length && col < matrix[row].length) {
            total += matrix[row][col];
            row++;
            col++;
        }
        return total;
    }

    private static int[][] createMatirx(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] entryRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = entryRow[col];
            }
        }

        return matrix;
    }
}
