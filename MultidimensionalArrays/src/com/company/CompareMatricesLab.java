package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element. For
better code reusability, you could do the comparison in a method, which returns true if they are equal and false if not.
Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in the
matrix and C – the number of columns – followed by R lines containing the C numbers, separated by spaces
(each line will have an equal amount of numbers.
The matrices will have at most 10 rows and at most 10 columns.
Print equal if the matrices match, and not equal if they don’t match.
 */

public class CompareMatricesLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // firstMatrix
        int[] firstSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstRow = firstSize[0];
        int firstCol = firstSize[1];

        int[][] firstMatrix = createMatrix(firstRow, firstCol, scanner);

        
        // secondMatrix
        int[] secondSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int secondRow = secondSize[0];
        int secondCol = secondSize[1];

        int[][] secondMatrix = createMatrix(secondRow, secondCol, scanner);
        
        
        // comparing matrices
        if (firstCol != secondCol) {
            System.out.println("not equal");
        } else {
            System.out.println(compare(firstMatrix, secondMatrix));
        }
    }

    private static String compare(int[][] firstMatrix, int[][] secondMatrix) {
        String areEqual = "equal";
        if (firstMatrix.length != secondMatrix.length) {
            return "not equal";
        }
        for (int red = 0; red < firstMatrix.length; red++) {
            for (int kolona = 0; kolona < firstMatrix[red].length; kolona++) {
                if (firstMatrix[red][kolona] != secondMatrix[red][kolona]) {
                    return "not equal";
                }
            }
        }
        return areEqual;
    }

    private static int[][] createMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] newRow = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(newRow[col]);
            }
        }
        return matrix;
    }
}
