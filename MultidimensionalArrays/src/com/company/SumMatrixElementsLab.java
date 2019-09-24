package com.company;

import java.lang.reflect.Array;
import java.text.Format;
import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads a matrix from the console and prints:
The count of rows
The count of columns
The sum of all matrix’s elements
On the first line you will get the dimensions of the matrix in format {rows, columns}. On the next lines you will get
the elements for each row separated with a coma.
 */
public class SumMatrixElementsLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];
        int total = 0;

        matrixBuilder(matrix, scanner);

        for (int[] row : matrix) {
            for (int num : row) {
                total += num;
            }
        }

        System.out.println(String.format("%d\n%d\n%d", rows, cols, total));
    }

    private static int[][] matrixBuilder(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] entryRow = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = entryRow[col];
            }
        }

        return matrix;
    }
}
