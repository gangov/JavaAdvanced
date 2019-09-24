package com.company;

import java.util.Arrays;
import java.util.Scanner;

//TO DO: make it better
/*
Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square. On
the first line you read a single integer N the matrix size. Then on each line N elements. The first diagonal should
always start with the element at the first row and col, the second diagonal should start with the element at the last
row and first col.
 */
public class PrintDiagonalsofSquareMatrixLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        //filling the matrix
        matrixBuilder(matrix, scanner);

        //printing diagonals
        topLeft(matrix, size);
        System.out.println();
        bottomLeft(matrix, size);
    }

    private static void bottomLeft(int[][] matrix, int size) {
        int[] secondDiagonal = new int[size];

        int row = size - 1;
        int col = 0;

        //filling from bottom left to top right
        while (row >= 0 && col <= matrix[row].length - 1) {
            secondDiagonal[col] = matrix[row][col];

            row--;
            col++;
        }
        for (int i : secondDiagonal) {
            System.out.print(i + " ");
        }
    }

    private static void topLeft(int[][] matrix, int size) {
        int[] firstDiagonal = new int[size];

        int row = 0;
        int col = 0;

        //filling from top left to bottom right
        while (row <= matrix.length - 1 && col <= matrix[row].length - 1) {
            firstDiagonal[row] = matrix[row][col];
            row++;
            col++;
        }
        for (int i : firstDiagonal) {
            System.out.print(i + " ");
        }
    }

    private static int[][] matrixBuilder(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] entryRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = entryRow[col];
            }
        }
        return matrix;
    }
}
