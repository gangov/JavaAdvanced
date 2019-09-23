package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints third matrix C[][]
which is filled with the intersecting elements of A and B, otherwise set the element to '*'. On the first two lines
you receive M and N, then on 2 * M lines N characters – the matrices elements.
The matrix elements may be any ASCII char except '*'.
 */
public class IntersectionofTwoMatricesLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        // building the first matrix
        String[][] firstMatrix = new String[rows][cols];
        matrixBuilder(rows, cols, firstMatrix, scanner);

        // building the second matrix
        String[][] secondMatrix = new String[rows][cols];
        matrixBuilder(rows, cols, secondMatrix, scanner);

        // comparing and overwriting the two matrices
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (!firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    firstMatrix[row][col] = "*";
                }
            }
        }

        for (String[] matrix : firstMatrix) {
            for (String s : matrix) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static String[][] matrixBuilder(int rows, int cols, String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] entryRow = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = entryRow[col];
            }
        }
        return matrix;
    }
}
