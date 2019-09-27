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
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);

        int[][] matrix = new int[rows][];
        matrixBuilder(matrix, scanner);
        printLowerDiagonals(matrix, Integer.parseInt(input[1]));
    }

    private static void printLowerDiagonals(int[][] matrix, int rowSize) {
        //printing the diagonals starting from the bottom part
        int col = matrix.length - 1;
        for (int start = matrix[col].length - 1; start >= 1; start--) {
            int nextUp = col;
            int nextRight = start;
            while (nextUp >= 0 && nextRight <= matrix[col].length - 1) {
                System.out.print(matrix[nextUp][nextRight] + " ");
                nextUp--;
                nextRight++;
            }
            System.out.println();
        }

        //printing the diagonals starting from the left part
        if (matrix.length <= rowSize) {
            for (int start = matrix.length - 1; start >= 0; start--) {
                //            System.out.println(matrix[start][0]);
                int upRow = start;
                int upRight = 0;
                while (upRow >= 0) {
                    System.out.print(matrix[upRow][upRight] + " "); //might be here
                    upRow--;
                    upRight++;
                }
                System.out.println();
            }
        } else {
            for (int start = matrix.length - 1; start >= 0; start--) {
                //            System.out.println(matrix[start][0]);
                int upRow = start;
                int upRight = 0;
                int turn = 0;
                while (upRow >= 0) {
                    if (upRight > matrix[upRow].length - 1) {
                        upRight = 0;
                        upRow--;
                    } else {
                        if (turn < matrix[upRow].length) {
                            System.out.print(matrix[upRow][upRight] + " "); //might be here
                            turn++;
                        }
                        upRow--;
                        upRight++;
                    }
                }
                System.out.println();
            }
        }
    }

    private static int[][] matrixBuilder(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}



/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] rowCol = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int [][] matrix = new int [rowCol[0]][rowCol[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int row = rowCol[0]-1;
        int col = rowCol[1]-1;

        while (row>=0){
            int r = row;
            int c = col;

            while (c<rowCol[1]&&r>=0){
                System.out.print(matrix[r--][c++]+" ");
            }
            System.out.println();

            col--;

            if (col==-1){
                col=0;
                row--;
            }
        }
    }
}
 */