package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/*
You are given a sequence of text lines. Assume these text lines form a matrix of characters (pad the missing positions
with spaces to build a rectangular matrix). Write a program to rotate the matrix by 90, 180, 270, 360, … degrees. Print
the result at the console as sequence of strings after receiving the “END” command.
 */
public class StringMatrixRotationExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int rotation = findOpenBracker(command);

        //getting the lines for our matrix
        String input = scanner.nextLine();
        ArrayList<String> worlds = new ArrayList<>();


        int cols = Integer.MIN_VALUE;

        while (!input.equals("END")) {
            if (input.length() > cols) {
                cols = input.length();
            }
            worlds.add(input);
            input = scanner.nextLine();
        }
        int rows = worlds.size();

        //size of our matrix

        //initialize matrix
        char[][] matrix = new char[rows][cols];
        matrixBuilder(rows, cols, matrix, worlds);


        //rotating the matrix
        if (rotation == 90) {
            rotate90(matrix, cols);
        } else if (rotation == 180) {
            rotate180(matrix);
        } else if (rotation == 270) {
            rotate270(matrix, cols);
        } else if (rotation == 360 || rotation == 0) {
            rotate360(matrix);
        }
    }

    private static void rotate360(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static void rotate270(char[][] matrix, int limit) {
        for (int col = limit - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static void rotate180(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static void rotate90(char[][] matrix, int limit) {
        for (int col = 0; col < limit; col++) {
            for (int row = matrix.length - 1; row >= 0 ; row--) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static int findOpenBracker(String command) {
        StringBuilder input = new StringBuilder(command);
        int start = 0;
        int end = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '(') {
                start = i;
            } else if (command.charAt(i) == ')') {
                end = i;
            }
        }

        int degree = Integer.parseInt(input.substring(start + 1, end));
        return degree % 360;
    }

    private static char[][] matrixBuilder(int rows, int cols, char[][] matrix, ArrayList<String> worlds) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = ' ';
            }
        }

        for (int charRow = 0; charRow < matrix.length; charRow++) {
            for (int charCol = 0; charCol < worlds.get(charRow).length(); charCol++) {
                matrix[charRow][charCol] = worlds.get(charRow).charAt(charCol);
            }
        }
        return matrix;
    }
}
