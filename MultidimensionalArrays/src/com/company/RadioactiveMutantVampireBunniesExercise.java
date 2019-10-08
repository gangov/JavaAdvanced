package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Browsing through GitHub, you come across an old JS Basics teamwork game. It is about very nasty bunnies that multiply
extremely fast. There’s also a player that has to escape from their lair. You really like the game so you decide to port
it to Java because that’s your language of choice. The last thing that is left is the algorithm that decides if the
player will escape the lair or not.
First, you will receive a line holding integers N and M, which represent the rows and columns in the lair. Then you
receive N strings that can only consist of “.”, “B”, “P”. The bunnies are marked with “B”, the player is marked with
“P”, and everything else is free space, marked with a dot “.”. They represent the initial state of the lair. There will
be only one player. Then you will receive a string with commands such as LLRRUUDD – where each letter represents the
next move of the player (Left, Right, Up, Down).
After each step of the player, each of the bunnies spread to the up, down, left and right (neighboring cells marked as
“.” changes their value to B). If the player moves to a bunny cell or a bunny reaches the player, the player has died.
If the player goes out of the lair without encountering a bunny, the player has won.
When the player dies or wins, the game ends. All the activities for this turn continue (e.g. all the bunnies spread
normally), but there are no more turns. There will be no stalemates where the moves of the player end before he dies or
escapes.
Finally, print the final state of the lair with every row on a separate line. On the last line, print either “dead:
{row} {col}” or “won: {row} {col}”. Row and col are the coordinates of the cell where the player has died or the last
cell he has been in before escaping the lair.

Input
On the first line of input, the numbers N and M are received – the number of rows and columns in the lair
On the next N lines, each row is received in the form of a string. The string will contain only “.”, “B”, “P”. All
strings will be the same length. There will be only one “P” for all the input
On the last line, the directions are received in the form of a string, containing “R”, “L”, “U”, “D”

Output
On the first N lines, print the final state of the bunny lair
On the last line, print the outcome – “won:” or “dead:” + {row} {col}

Constraints
The dimensions of the lair are in range [3…20]
The directions string length is in range [1…20]
 */
public class RadioactiveMutantVampireBunniesExercise {
    static int[] playerPosition = new int[]{0, 0};
    static boolean isSafe = false;
    static boolean bunnyBomb = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputRowsCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = inputRowsCols[0];
        int cols = inputRowsCols[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split("");
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = input[j];
                if (input[j].equals("P")) {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }

        String[] moves = scanner.nextLine().split("");

        String finalMessage = "";

        for (int i = 0; i < moves.length; i++) {
            movePlayer(matrix, moves[i], playerPosition);
            if (isSafe) {
                finalMessage = "won: " + playerPosition[0] + " " + playerPosition[1];
            } else if (bunnyBomb) {
                finalMessage = "dead: " + playerPosition[0] + " " + playerPosition[1];
            }
            List<int[]> allBunnies = getBunnyLocation(matrix);
            spreadEmBunnies(matrix, allBunnies);
            if (bunnyBomb) {
                finalMessage = "dead: " + playerPosition[0] + " " + playerPosition[1];
            }
            if (isSafe || bunnyBomb) {
                break;
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int j = 0; j < matrix[k].length; j++) {
                System.out.print(matrix[k][j]);
            }
            System.out.println();
        }
        System.out.println(finalMessage);
    }

    private static String[][] spreadEmBunnies(String[][] matrix, List<int[]> allBunnies) {
        for (int[] bunny : allBunnies) {
            int row = bunny[0];
            int col = bunny[1];
            if (matrix[row][col].equals("P")) {
                bunnyBomb = true;
            }
            matrix[row][col] = "B";
        }
        return matrix;
    }

    private static List<int[]> getBunnyLocation(String[][] matrix) {

        List<int[]> bunnyLocations = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    if (row - 1 >= 0) {
                        bunnyLocations.add(new int[]{row - 1, col});
                    }
                    if (row + 1 < matrix.length) {
                        bunnyLocations.add(new int[]{row + 1, col});
                    }
                    if (col - 1 >= 0) {
                        bunnyLocations.add(new int[]{row, col - 1});
                    }
                    if (col + 1 < matrix[row].length) {
                        bunnyLocations.add(new int[]{row, col + 1});
                    }
                }
            }
        }

        return bunnyLocations;
    }

    private static String[][] movePlayer(String[][] matrix, String move, int[] playerPosition) {
        int row = playerPosition[0];
        int col = playerPosition[1];

        if (move.equals("U")) {
            if (row - 1 >= 0) {
                if (matrix[row - 1][col].equals("B")) {
                    bunnyBomb = true;
                } else {
                    matrix[row - 1][col] = "P";
                }
                matrix[row][col] = ".";
                playerPosition[0] = row - 1;
            } else {
                matrix[row][col] = ".";
                isSafe = true;
            }
        } else if (move.equals("D")) {
            if (row + 1 < matrix.length) {
                if (matrix[row + 1][col].equals("B")) {
                    bunnyBomb = true;
                } else {
                    matrix[row + 1][col] = "P";
                }
                matrix[row][col] = ".";
                playerPosition[0] = row + 1;
            } else {
                matrix[row][col] = ".";
                isSafe = true;
            }
        } else if (move.equals("L")) {
            if (col - 1 >= 0) {
                if (matrix[row][col - 1].equals("B")) {
                    bunnyBomb = true;
                } else {
                    matrix[row][col - 1] = "P";
                }
                matrix[row][col] = ".";
                playerPosition[1] = col - 1;
            } else {
                matrix[row][col] = ".";
                isSafe = true;
            }
        } else if (move.equals("R")) {
            if (col + 1 < matrix[row].length) {
                if (matrix[row][col + 1].equals("B")) {
                    bunnyBomb = true;
                } else {
                    matrix[row][col + 1] = "P";
                }
                matrix[row][col] = ".";
                playerPosition[1] = col + 1;
            } else {
                matrix[row][col] = ".";
                isSafe = true;
            }
        }
        return matrix;
    }
}
