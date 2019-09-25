package com.company;

import java.util.Scanner;

/*
Filling a matrix in the regular way (top to bottom and left to right) is boring. Write two methods that fill a matrix
of size N x N in two different patterns. Both patterns are described below:
1 - 5 - 9 - 13          1 - 8 - 9 - 16
2 - 6 - 10 - 14         2 - 7 - 10 - 15
3 - 7 - 11 - 15         3 - 6 - 11 - 14
4 - 8 - 12 - 16         4 - 5 - 12 - 13
 */
public class FilltheMatrixExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        int limit = size * size;
        String type = input[1];

        int[][] matrix = new int[size][size];

        //building the matrix
        if (type.equals("A")) {
            matrixBuilderA(matrix);
        } else {
            matrixBuilderB(matrix);
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] matrixBuilderB(int[][] matrix) {
        int start = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[col][row] = start++;
                }
            } else {
                for (int col = matrix[row].length - 1; col >= 0; col--) {
                    matrix[col][row] = start++;
                }
            }
        }
        return matrix;
    }

    private static int[][] matrixBuilderA(int[][] matrix) {
        int start = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = start++;
            }
        }

        return matrix;
    }
}
