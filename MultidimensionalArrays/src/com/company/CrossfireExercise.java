package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
You will receive two integers which represent the dimensions of a matrix. Then, you must fill the matrix with
increasing integers starting from 1, and continuing on every row, like this: first row: 1, 2, 3, …, n second row:
n + 1, n + 2, n + 3, …, n + n third row: 2 * n + 1, 2 * n + 2, …, 2 * n + n
You will also receive several commands in the form of 3 integers separated by a space. Those 3 integers will represent
a row in the matrix, a column and a radius. You must then destroy the cells which correspond to those arguments
cross-like.
Destroying a cell means that, that cell becomes completely nonexistent in the matrix. Destroying cells cross-like means
that you form a cross figure with center point - equal to the cell with coordinates – the given row and column, and
lines with length equal to the given radius. See the examples for more info.
The input ends when you receive the command “Nuke it from orbit”. When that happens, you must print what has remained
from the initial matrix.

Input
On the first line you will receive the dimensions of the matrix. You must then fill the matrix according to those
dimensions
On the next several lines you will begin receiving 3 integers separated by a single space, which represent the row, col
and radius. You must then destroy cells according to those coordinates
When you receive the command “Nuke it from orbit” the input ends

Output
The output is simple. You must print what is left from the matrix
Every row must be printed on a new line and every column of a row - separated by a space

 */
public class CrossfireExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];
        matrixBuilder(matrix);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            String[] coordinates = command.split(" ");
            int row = Integer.parseInt(coordinates[0]);
            int col = Integer.parseInt(coordinates[1]);
            int radius = Integer.parseInt(coordinates[2]);

            updateMatrix(matrix, row, col, radius);
            command = scanner.nextLine();
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static String[][] updateMatrix(String[][] matrix, int row, int col, int radius) {
        //find position

        matrix[row][col] = " ";
        deleteLeft(matrix, row, col, radius);
        deleteRight(matrix, row, col, radius);
        deleteUp(matrix, row, col, radius);
        deleteDown(matrix, row, col, radius);
        fillInTheBlanks(matrix);
        return matrix;
    }

    private static String[][] fillInTheBlanks(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            ArrayList<String> newEntryRow = new ArrayList<>();
            int emptyCount = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                if (!matrix[row][col].equals(" ")) {
                    newEntryRow.add(matrix[row][col]);
                } else {
                    emptyCount++;
                }
            }
            for (int i = 0; i < emptyCount; i++) {
                newEntryRow.add(" ");
            }
            matrix[row] = newEntryRow.toArray(new String[newEntryRow.size()]);
        }
        return matrix;
    }

    private static String deleteDown(String[][] matrix, int row, int col, int radius) {
        int end = row + radius;
        while (row <= end && row <= matrix.length - 1) {
            matrix[row][col] = " ";
            if (row < matrix.length - 1) {
                row++;
            } else {
                break;
            }
        }
        return matrix[row][col];
    }

    private static String deleteUp(String[][] matrix, int row, int col, int radius) {
        int end = row - radius;
        while (row >= end && row >= 0) {
            matrix[row][col] = " ";
            if (row > 0) {
                row--;
            } else {
                break;
            }
        }
        return matrix[row][col];
    }

    private static String deleteRight(String[][] matrix, int row, int col, int radius) {
        int end = col + radius;
        while (col <= end && col <= matrix[row].length - 1) {
            matrix[row][col] = " ";
            if (col < matrix[row].length - 1) {
                col++;
            } else {
                break;
            }
        }
        return matrix[row][col];
    }

    private static String deleteLeft(String[][] matrix, int row, int col, int radius) {
        int end = col - radius;
        while (col >= end && col >= 0) {
            matrix[row][col] = " ";
            if (col > 0) {
                col--;
            } else {
                break;
            }
        }
        return matrix[row][col];
    }

    private static String[][] matrixBuilder(String[][] matrix) {
        int n = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(n++);
            }
        }
        return matrix;
    }
}
