package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads a rectangular integer matrix of size N x M and finds in it the square 3 x 3 that has
maximal sum of its elements.
 */
public class MaximalSumExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        createMatrix(matrix, scanner);

        //find largestSum and matrix
        int[][] largestMatrix = new int[3][3];
        int maximumNum = Integer.MIN_VALUE;

        findLargestMatrix(matrix, largestMatrix, maximumNum);
    }

    private static void findLargestMatrix(int[][] originMatrix, int[][] largestMatrix, int maximumNum) {
        int total = 0;
        for (int row = 0; row <= originMatrix.length - 3; row++) {
            for (int col = 0; col <= originMatrix[row].length - 3; col++) {
                int one = originMatrix[row][col];
                int two = originMatrix[row][col + 1];
                int three = originMatrix[row][col + 2];
                int four = originMatrix[row + 1][col];
                int five = originMatrix[row + 1][col + 1];
                int six = originMatrix[row + 1][col + 2];
                int seven = originMatrix[row + 2][col];
                int eight = originMatrix[row + 2][col + 1];
                int nine = originMatrix[row + 2][col + 2];

                total = one + two + three + four + five + six + seven + eight + nine;
                if (total > maximumNum) {
                    maximumNum = total;
                    largestMatrix[0][0] = one;
                    largestMatrix[0][1] = two;
                    largestMatrix[0][2] = three;
                    largestMatrix[1][0] = four;
                    largestMatrix[1][1] = five;
                    largestMatrix[1][2] = six;
                    largestMatrix[2][0] = seven;
                    largestMatrix[2][1] = eight;
                    largestMatrix[2][2] = nine;
                }
            }
        }


        System.out.println("Sum = " + maximumNum);
        for (int[] matrix : largestMatrix) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] entryRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = entryRow;
        }
        return matrix;
    }
}
