package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
You are given a matrix (2D array) of integers. You have to print the matrix diagonal but in reversed order. Print each
diagonal on new line.

Input
On the first line, single integer the number R of rows in the matrix. On each of the next R lines, C numbers separated
by single spaces. Note that R and C may have different values.

Output
The output should consist of R lines, each consisting of exactly C characters, separated by spaces, representing the
matrix diagonals reversed.

Constraints
All the integers will be in the range [1….1000]

 */
public class ReverseMatrixDiagonalsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];
        matrixBuilder(matrix, scanner);
        printLowerDiagonals(matrix, cols);
    }

    private static void printLowerDiagonals(int[][] matrix, int rowSize) {
        //printing the diagonals starting from the bottom part
        int row = matrix.length - 1;
        for (int start = matrix[row].length - 1; start >= 0; start--) {
            int nextUp = row;
            int nextRight = start;
            while (nextUp >= 0 && nextRight <= matrix[row].length - 1) {
                System.out.print(matrix[nextUp][nextRight] + " ");
                nextUp--;
                nextRight++;
            }
            System.out.println();
        }

        //printing the diagonals starting from the left part
        for (int start = matrix.length - 2; start >= 0; start--) {
//            System.out.println(matrix[start][0]);
            int upRow = start;
            int upRight = 0;
            while (upRow >= 0) {
                System.out.print(matrix[upRow][upRight] + " ");
                upRow--;
                upRight++;
            }
            System.out.println();
        }
    }

    private static int[][] matrixBuilder(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
