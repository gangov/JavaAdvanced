package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program that reads a matrix of integers from the console, then a number and prints all the positions at which
that number appears in the matrix.
The matrix definition on the console will contain a line with two positive integer numbers R and C – the number of
rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces), representing
each row of the matrix.
The number you will need to find the positions of will be entered on a single line, after the matrix.
You should print each position on a single line – first print the row, then the column at which the number appears.
If the number does not appear in the matrix, print not found

 */
public class PositionOfLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entry numbers
        int[] entry = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = entry[0];
        int col = entry[1];

        int[][] matrix = new int[row][col];


        // matrix to be build
        for (int rows = 0; rows < matrix.length; rows++) {
            int[] rowNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                matrix[rows][cols] = rowNumbers[cols];
            }
        }

        // number to be found
        int findMe = Integer.parseInt(scanner.nextLine());
        boolean isThere = false;

        // printing the lines, that need to be found
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == findMe) {
                    System.out.println(r + " " + c);
                    isThere = true;
                }
            }
        }

        if (!isThere) {
            System.out.println("not found");
        }
    }
}
