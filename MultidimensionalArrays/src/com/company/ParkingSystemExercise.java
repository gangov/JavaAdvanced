package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
The parking lot in front of SoftUni is one of the busiest in the country, and it’s a common cause for conflicts between
the doorkeeper Bai Tzetzo and the students. The SoftUni team wants to proactively resolve all conflicts, so an automated
parking system should be implemented. They are organizing a competition – Parkoniada – and the author of the best
parking system will win a romantic dinner with RoYaL. That’s exactly what you’ve been dreaming of, so you decide to join
in.
The parking lot is a rectangular matrix where the first column is always free and all other cells are parking spots. A
car can enter from any cell of the first column and then decides to go to a specific spot. If that spot is not free, the
car searches for the closest free spot on the same row. If all the cells on that specific row are used, the car cannot
park and leaves. If two free cells are located at the same distance from the initial parking spot, the cell which is
closer to the entrance is preferred. A car can pass through a used parking spot.
Your task is to calculate the distance travelled by each car to its parking spot.
Example: A car enters the parking at row 1. It wants to go to cell 2, 2 so it moves through exactly four cells to reach
its parking spot.

Input
On the first line of input, you are given the integers R and C, defining the dimensions of the parking lot
On the next several lines, you are given the integers Z, X, Y where Z is the entry row and X, Y are the coordinates of
the desired parking spot
The input stops with the command ‘stop’. All integers are separated by a single space

Output
For each car, print the distance travelled to the desired spot or the first free spot
If a car cannot park on its desired row, print the message ‘Row {row number} full’

Constraints
2 ≤ R,C ≤ 10000
Z, X, Y are inside the dimensions of the matrix. Y is never on the first column
There are no more than 1000 input lines
Allowed time/space: 0.1s (C#) /16MB
 */
public class ParkingSystemExercise {
    static int finalCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputRowsCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = inputRowsCols[0];
        int cols = inputRowsCols[1];

        int[][] matrix = new int[rows][cols];

        String tokens = scanner.nextLine();

        while (!tokens.equals("stop")) {

            int[] input = Arrays.stream(tokens.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = input[0];
            int desiredRow = input[1];
            int desiredCol = input[2];

            if (checkIfFreeSpot(matrix, desiredRow, desiredCol)) {
                printMoves(entryRow, desiredRow);
            } else {
                System.out.println(String.format("Row %d full", desiredRow));
            }


            tokens = scanner.nextLine();
        }


    }

    private static void printMoves(int entryRow, int desiredRow) {
        int count = 1 + Math.abs(desiredRow - entryRow) + finalCol;
        System.out.println(count);
    }

    private static boolean checkIfFreeSpot(int[][] matrix, int desiredRow, int desiredCol) {
        boolean isFree = false;
        int toTheLeft = desiredCol;
        int toTheRight = desiredCol;
        while (toTheLeft >= 1 || toTheRight < matrix[desiredRow].length) {

            if (toTheLeft >= 1 && matrix[desiredRow][toTheLeft] == 0) {
                matrix[desiredRow][toTheLeft] = 1;
                isFree = true;
                finalCol = toTheLeft;
                break;
            }
            if (toTheRight < matrix[desiredRow].length && matrix[desiredRow][toTheRight] == 0) {
                matrix[desiredRow][toTheRight] = 1;
                isFree = true;
                finalCol = toTheRight;
                break;
            }


            toTheLeft--;
            toTheRight++;
        }


        return isFree;
    }
}

