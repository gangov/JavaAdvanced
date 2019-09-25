package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Write a program which reads a string matrix from the console and performs certain operations with its elements. User
input is provided in a similar way like in the problems above – first you read the dimensions and then the data.
Your program should then receive commands in format: "swap row1 col1 row2c col2" where row1, row2, col1, col2 are
coordinates in the matrix. In order for a command to be valid, it should start with the "swap" keyword along with four
valid coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1, col1] with cell
[row2, col2]) and print the matrix at each step (thus you'll be able to check if the operation was performed correctly).
If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered or the given
coordinates do not exist), print "Invalid input!" and move on to the next command. Your program should finish when the
string "END" is entered.
 */
public class MatrixShufflingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        //build the matrix
        String[][] matrix = new String[rows][cols];
        matrixBuilder(matrix, scanner);

        //reading the input commands

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("END")) {
            //checking if alles ist in ordnung
            boolean hasFault = false;
            if (!command[0].equals("swap")) {
                System.out.println("Invalid input!");
                command = scanner.nextLine().split(" ");
            } else if (command.length - 1 != 4) {
                System.out.println("Invalid input!");
                command = scanner.nextLine().split(" ");
            }
            int startRow = Integer.parseInt(command[1]);
            int startCol = Integer.parseInt(command[2]);
            int endRow = Integer.parseInt(command[3]);
            int endCol = Integer.parseInt(command[4]);


            //swapping values
            try {
                String start = matrix[startRow][startCol];
                String medium = matrix[endRow][endCol];

                matrix[startRow][startCol] = medium;
                matrix[endRow][endCol] = start;
            } catch (Exception e) {
                System.out.println("Invalid input!");
                hasFault = true;
            } finally {
                command = scanner.nextLine().split(" ");
            }

            if (!hasFault) {
                for (String[] strings : matrix) {
                    for (String string : strings) {
                        System.out.print(string + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static String[][] matrixBuilder(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] entryRow = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = entryRow[col];
            }
        }
        return matrix;
    }
}
