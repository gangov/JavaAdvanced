package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads a matrix from the console. Then find the biggest sum of a 2x2 submatrix. Print the
submatrix and its sum.
On the first line you will get the dimensions of the matrix in format {rows, columns}. On the next lines you will get
the elements for each row separated with a coma.
 */
public class MaximumSumof2x2SubmatrixLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] entry = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = entry[0];
        int cols = entry[1];

        int maxNum = Integer.MIN_VALUE;

        //reading the matrix
        int[][] matrix = new int[rows][cols];
        matrixBuilder(matrix, scanner);

        int[][] biggestMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentTotal = 0;
                currentTotal += matrix[row][col];
                currentTotal += matrix[row][col + 1];
                currentTotal += matrix[row + 1][col];
                currentTotal += matrix[row + 1][col + 1];

                if (currentTotal > maxNum) {
                    maxNum = currentTotal;
                    biggestMatrix[0][0] = matrix[row][col];
                    biggestMatrix[0][1] = matrix[row][col + 1];
                    biggestMatrix[1][0] = matrix[row + 1][col];
                    biggestMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        for (int[] ints : biggestMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(maxNum);
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
