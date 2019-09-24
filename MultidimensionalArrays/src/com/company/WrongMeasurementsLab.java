package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
You will be given the rows of a matrix. Then the matrix itself. Inside this matrix there are mistaken values which need
to be replaced you will receive the wrong value at the last line. Those values should be replaced with the sum of the
nearest elements in the four directions up, down, left and right, but only if they are valid values. At the end you
have to print the fixed measurements.
 */
public class WrongMeasurementsLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        //initializing matrix
        int[][] matrix = new int[size][];
        int[][] newMatrix = matrix;
        matrixBuilder(matrix, scanner);

        //detecting the faulty element
        int[] faultCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int fault = matrix[faultCoordinates[0]][faultCoordinates[1]];

        ArrayList<Integer> newValues = new ArrayList<>();
        ArrayList<int[]> index = new ArrayList<>();

        //making changes to the matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == fault) {
                    int changed = changeNumber(row, col, fault, matrix);
                    newValues.add(changed);
                    index.add(new int[]{row, col});
                }
            }
        }

        for (int i = 0; i < newValues.size(); i++) {
            matrix[index.get(i)[0]][index.get(i)[1]] = newValues.get(i);
        }
        
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int changeNumber(int row, int col, int fault, int[][] matrix) {
        int number = 0;

        if (row - 1 >= 0) {
            if (matrix[row - 1][col] != fault) number += matrix[row - 1][col];
        }
        if (row + 1 <= matrix.length - 1) {
            if (matrix[row + 1][col] != fault) number += matrix[row + 1][col];
        }
        if (col - 1 >= 0) {
            if (matrix[row][col - 1] != fault) number += matrix[row][col - 1];
        }
        if (col + 1 <= matrix[row].length - 1) {
            if (matrix[row][col + 1] != fault) number += matrix[row][col + 1];
        }

        return number;
    }

    private static int[][] matrixBuilder(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] entryRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = entryRow;
        }
        return matrix;
    }
}
