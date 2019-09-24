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
        char[][] firstMatrix = new char[rows][cols];
        matrixBuilder(firstMatrix, scanner);

        // building the second matrix
        char[][] secondMatrix = new char[rows][cols];
        matrixBuilder(secondMatrix, scanner);

        // comparing and overwriting the two matrices
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (!(firstMatrix[row][col] == (secondMatrix[row][col]))) {
                    firstMatrix[row][col] = '*';
                }
            }
        }

        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {
                System.out.print(firstMatrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] matrixBuilder(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] entryRow = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = entryRow[col].charAt(0);
            }
        }
        return matrix;
    }
}
