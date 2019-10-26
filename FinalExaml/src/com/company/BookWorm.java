package com.company;
/*
You will be given a string. Then, you will be given an integer N for the size of the field with square shape. On the
next N lines, you will receive the rows of the field. The player will be placed on a random position, marked with "P".
On random positions there will be letters. All of the empty positions will be marked with "-".
Each turn you will be given commands for the player’s movement. If he moves to a letter, he consumes it, concatеnates it
to the initial string and the letter disappears from the field. If he tries to move outside of the field, he is punished
- he loses the last letter in the string, if there are any, and the player’s position is not changed.
When the command "end" is received, stop the program, print all letters and the field.


Input
On the first line, you are given the initial string
On the second line, you are given the integer N - the size of the square matrix
The next N lines holds the values for every row
On each of the next lines you will get a move command


Output
On the first line the final state of the string
In the end print the matrix


Constraints
The size of the square matrix will be between [2…10]
The player position will be marked with "P"
The letters on the field will be any letter except for "P"
Move commands will be: "up", "down", "left", "right"
Stop command will be "end"
 */
import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder begin = new StringBuilder(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int i = 0; i < matrix[row].length; i++) {
                if (matrix[row][i].equals("P")) {
                    playerRow = row;
                    playerCol = i;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        if (!matrix[playerRow - 1][playerCol].equals("-")) {
                            begin.append(matrix[playerRow - 1][playerCol]);
                            matrix[playerRow][playerCol] = "-";
                            matrix[playerRow - 1][playerCol] = "P";
                            playerRow -= 1;
                        } else {
                            matrix[playerRow][playerCol] = "-";
                            matrix[playerRow - 1][playerCol] = "P";
                            playerRow -= 1;
                        }
                    } else {
                        begin.deleteCharAt(begin.length() - 1);
                    }
                    break;
                case "down":
                    if (playerRow + 1 < matrix.length) {
                        if (!matrix[playerRow + 1][playerCol].equals("-")) {
                            begin.append(matrix[playerRow + 1][playerCol]);
                            matrix[playerRow][playerCol] = "-";
                            matrix[playerRow + 1][playerCol] = "P";
                            playerRow += 1;
                        } else {
                            matrix[playerRow][playerCol] = "-";
                            matrix[playerRow + 1][playerCol] = "P";
                            playerRow += 1;
                        }
                    } else {
                        begin.deleteCharAt(begin.length() - 1);
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0) {
                        if (!matrix[playerRow][playerCol - 1].equals("-")) {
                            begin.append(matrix[playerRow][playerCol - 1]);
                            matrix[playerRow][playerCol] = "-";
                            matrix[playerRow][playerCol - 1] = "P";
                            playerCol -= 1;
                        } else {
                            matrix[playerRow][playerCol] = "-";
                            matrix[playerRow][playerCol - 1] = "P";
                            playerCol -= 1;
                        }
                    } else {
                        begin.deleteCharAt(begin.length() - 1);
                    }
                    break;
                case "right":
                    if (playerCol + 1 < matrix.length) {
                        if (!matrix[playerRow][playerCol + 1].equals("-")) {
                            begin.append(matrix[playerRow][playerCol + 1]);
                            matrix[playerRow][playerCol] = "-";
                            matrix[playerRow][playerCol + 1] = "P";
                            playerCol += 1;
                        } else {
                            matrix[playerRow][playerCol] = "-";
                            matrix[playerRow][playerCol + 1] = "P";
                            playerCol += 1;
                        }
                    } else {
                        begin.deleteCharAt(begin.length() - 1);
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        System.out.println(begin);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
