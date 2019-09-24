package com.company;

import java.util.Scanner;

/*
Write a program that reads (8 x 8) matrix of characters from the console. The matrix represents a chess board with
figures on it. The figures can be - queens as char 'q' or any other ASCII symbol. There will be more than one queen
but only one queen will have valid position, which is not attacked from any other queen and does not attack any other
queen. In other word in the way of the valid queen there are no other queens, but there may be any other ASCII symbol.
Your task is to read the chessboard and find the position of the valid queen. According to chess rules the queen can
attack all the cells in horizontal vertical and both diagonals which cross the queen position.
 */
public class FindTheRealQueenLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];

        matrixBuilder(matrix, scanner);
        findTheQueen(matrix);
    }

    private static void findTheQueen(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    int currentQueenRow = row;
                    int currentQueenCol = col;
                    checkVertical(currentQueenCol, matrix);
                    checkHorizontal(currentQueenRow, matrix);
                    checkUpLeft(currentQueenRow, currentQueenCol, matrix);
                    checkUpRight(currentQueenRow, currentQueenCol, matrix);
                    checkDownLeft(currentQueenRow, currentQueenCol, matrix);
                    checkDownRight(currentQueenRow, currentQueenCol, matrix);

                    //total
                    if (checkVertical(currentQueenCol, matrix)
                            && checkHorizontal(currentQueenRow, matrix)
                            && checkUpLeft(currentQueenRow, currentQueenCol, matrix)
                            && checkUpRight(currentQueenRow, currentQueenCol, matrix)
                            && checkDownLeft(currentQueenRow, currentQueenCol, matrix)
                            && checkDownRight(currentQueenRow, currentQueenCol, matrix)) {
                        System.out.print(row + " " + col);
                    }
                }
            }
        }
    }

    private static boolean checkDownRight(int currentQueenRow, int currentQueenCol, char[][] matrix) {
        int queenCount = 0;

        while (currentQueenRow < 8 && currentQueenCol < 8) {
            if (matrix[currentQueenRow][currentQueenCol] == 'q') {
                queenCount++;
            }
            currentQueenRow++;
            currentQueenCol++;
        }
        return queenCount <= 1;
    }

    private static boolean checkDownLeft(int currentQueenRow, int currentQueenCol, char[][] matrix) {
        int queenCount = 0;
        while (currentQueenRow < 8 && currentQueenCol >= 0) {
            if (matrix[currentQueenRow][currentQueenCol] == 'q') {
                queenCount++;
            }
            currentQueenRow++;
            currentQueenCol--;
        }
        return queenCount <= 1;
    }

    private static boolean checkUpRight(int currentQueenRow, int currentQueenCol, char[][] matrix) {
        int queenCount = 0;
        while (currentQueenRow >= 0 && currentQueenCol < 8) {
            if (matrix[currentQueenRow][currentQueenCol] == 'q') {
                queenCount++;
            }
            currentQueenRow--;
            currentQueenCol++;
        }
        return queenCount <= 1;
    }

    private static boolean checkUpLeft(int currentQueenRow, int currentQueenCol, char[][] matrix) {
        int queenCount = 0;
        while (currentQueenRow >= 0 && currentQueenCol >= 0) {
            if (matrix[currentQueenRow][currentQueenCol] == 'q') {
                queenCount++;
            }
            currentQueenRow--;
            currentQueenCol--;
        }

        return queenCount <= 1;
    }

    private static boolean checkHorizontal(int currentQueenRow, char[][] matrix) {
        int queenCount = 0;
        int col = 0;
        while (col < 8) {
            if (matrix[currentQueenRow][col] == 'q') {
                queenCount++;
            }
            col++;
        }

        return queenCount <= 1;
    }

    private static boolean checkVertical(int currentQueenCol, char[][] matrix) {
        int queenCount = 0;
        int row = 0;
        while (row < 8) {
            if (matrix[row][currentQueenCol] == 'q') {
                queenCount++;
            }
            row++;
        }

        return queenCount <= 1;
    }


    private static char[][] matrixBuilder(char[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            String[] entryRow = sc.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = entryRow[col].charAt(0);
            }
        }
        return matrix;
    }
}
