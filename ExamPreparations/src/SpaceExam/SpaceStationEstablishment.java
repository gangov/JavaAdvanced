package SpaceExam;

import java.util.Scanner;

/*
Stephen successfully started his journey in the galaxy and now he has to collect some star power in order to establish
his very own Space Station.
You will be given an integer n for the size of the galaxy with square shape. On the next n lines, you will receive the
rows of the galaxy. Stephen’s spaceship will be placed on a random position, marked with the letter 'S'. On random
positions there will be stars, marked with a single digit. There may also be black holes. Their count will be either 0
or 2 and they are marked with the letter - 'O'. All of the empty positions will be marked with '-'.
Each turn, you will be given commands for the player’s movement. Move commands will be: "up", "down", "left", "right".
If he moves to a star, he collects energy equal to the digit there and the star disappears. If he moves to a black hole,
he appears on the position of the other black hole and then both black holes disappear. If a player goes out of the
galaxy, he goes into the void, disappears from the galaxy and is lost forever. He needs at least 50 star power to build
the Space Station.
When the player is lost in the void or collects enough star power, the journey ends.


Input
On the first line, you are given the integer n – the size of the square matrix.

The next n lines holds the values for every row.

On each of the next lines you will get a move command.


Output
On the first line:
If the player goes to the void, print: "Bad news, the spaceship went to the void."
If the player collects enough star power, print: "Good news! Stephen succeeded in collecting enough star power!"

On the second line print all star power collected: "Star power collected: {starPower}"

In the end print the matrix.


Constraints
The size of the square matrix will be between [2…10].
There will always be 0 or 2 black holes, marked with the letter - 'O'.
The player position will be marked with 'S'.
The player will always go to the void or collect enough star power.
 */
public class SpaceStationEstablishment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] galaxy = new char[size][size];

        int playerRow = -1;
        int playerCol = -1;
        int blackHoleCount = 0;
        int firstBlackHoleRow = -1;
        int firstBlackHoleCol = -1;
        int secondBlackHoleRow = -1;
        int secondBlackHoleCol = -1;
        for (int i = 0; i < galaxy.length; i++) {
            String b = scanner.nextLine();
            galaxy[i] = b.toCharArray();
            if (b.contains("S")) {
                playerRow = i;
                playerCol = b.indexOf('S');
            }
            if (b.contains("O")) {
                if (blackHoleCount == 0) {
                    firstBlackHoleRow = i;
                    firstBlackHoleCol = b.indexOf('O');
                    blackHoleCount++;
                } else {
                    secondBlackHoleRow = i;
                    secondBlackHoleCol = b.indexOf('O');
                }
            }
        }


        int energy = 0;
        boolean isIn = true;
        while (isIn && energy < 50) {
            String direction = scanner.nextLine();

            switch (direction) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        galaxy[playerRow][playerCol] = '-';
                        if (Character.isDigit(galaxy[playerRow - 1][playerCol])) {
                            energy += Character.getNumericValue(galaxy[playerRow - 1][playerCol]);
                            galaxy[playerRow - 1][playerCol] = 'S';
                            playerRow -= 1;
                        } else if (galaxy[playerRow - 1][playerCol] == 'O') {
                            if (playerRow - 1 == firstBlackHoleRow && playerCol == firstBlackHoleCol) {
                                galaxy[firstBlackHoleRow][firstBlackHoleCol] = '-';
                                galaxy[secondBlackHoleRow][secondBlackHoleCol] = 'S';
                                playerRow = secondBlackHoleRow;
                                playerCol = secondBlackHoleCol;
                            } else if (playerRow - 1 == secondBlackHoleRow && playerCol == secondBlackHoleCol) {
                                galaxy[secondBlackHoleRow][secondBlackHoleCol] = '-';
                                galaxy[firstBlackHoleRow][firstBlackHoleCol] = 'S';
                                playerRow = firstBlackHoleRow;
                                playerCol = firstBlackHoleCol;
                            }
                        } else {
                            galaxy[playerRow - 1][playerCol] = 'S';
                            playerRow -= 1;
                        }
                    } else {
                        galaxy[playerRow][playerCol] = '-';
                        isIn = false;
                        break;
                    }
                    break;

                case "right":
                    if (playerCol + 1 < galaxy.length) {
                        galaxy[playerRow][playerCol] = '-';
                        if (Character.isDigit(galaxy[playerRow][playerCol + 1])) {
                            energy += Character.getNumericValue(galaxy[playerRow][playerCol + 1]);
                            galaxy[playerRow][playerCol + 1] = 'S';
                            playerCol += 1;
                        } else if (galaxy[playerRow][playerCol + 1] == 'O') {
                            if (playerRow == firstBlackHoleRow && playerCol + 1 == firstBlackHoleCol) {
                                galaxy[firstBlackHoleRow][firstBlackHoleCol] = '-';
                                galaxy[secondBlackHoleRow][secondBlackHoleCol] = 'S';
                                playerRow = secondBlackHoleRow;
                                playerCol = secondBlackHoleCol;
                            } else if (playerRow== secondBlackHoleRow && playerCol + 1== secondBlackHoleCol) {
                                galaxy[secondBlackHoleRow][secondBlackHoleCol] = '-';
                                galaxy[firstBlackHoleRow][firstBlackHoleCol] = 'S';
                                playerRow = firstBlackHoleRow;
                                playerCol = firstBlackHoleCol;
                            }
                        } else {
                            galaxy[playerRow][playerCol + 1] = 'S';
                            playerCol += 1;
                        }
                    } else {
                        galaxy[playerRow][playerCol] = '-';
                        isIn = false;
                        break;
                    }
                    break;

                case "down":
                    if (playerRow + 1 < galaxy.length) {
                        galaxy[playerRow][playerCol] = '-';
                        if (Character.isDigit(galaxy[playerRow + 1][playerCol])) {
                            energy += Character.getNumericValue(galaxy[playerRow + 1][playerCol]);
                            galaxy[playerRow + 1][playerCol] = 'S';
                            playerRow += 1;
                        } else if (galaxy[playerRow + 1][playerCol] == 'O') {
                            if (playerRow + 1 == firstBlackHoleRow && playerCol == firstBlackHoleCol) {
                                galaxy[firstBlackHoleRow][firstBlackHoleCol] = '-';
                                galaxy[secondBlackHoleRow][secondBlackHoleCol] = 'S';
                                playerRow = secondBlackHoleRow;
                                playerCol = secondBlackHoleCol;
                            } else if (playerRow + 1 == secondBlackHoleRow && playerCol == secondBlackHoleCol) {
                                galaxy[secondBlackHoleRow][secondBlackHoleCol] = '-';
                                galaxy[firstBlackHoleRow][firstBlackHoleCol] = 'S';
                                playerRow = firstBlackHoleRow;
                                playerCol = firstBlackHoleCol;
                            }
                        } else {
                            galaxy[playerRow + 1][playerCol] = 'S';
                            playerRow += 1;
                        }
                    } else {
                        galaxy[playerRow][playerCol] = '-';
                        isIn = false;
                        break;
                    }
                    break;

                case "left":
                    if (playerCol - 1 >= 0) {
                        galaxy[playerRow][playerCol] = '-';
                        if (Character.isDigit(galaxy[playerRow][playerCol - 1])) {
                            energy += Character.getNumericValue(galaxy[playerRow][playerCol - 1]);
                            galaxy[playerRow][playerCol - 1] = 'S';
                            playerCol -= 1;
                        } else if (galaxy[playerRow][playerCol - 1] == 'O') {
                            if (playerRow == firstBlackHoleRow && playerCol - 1 == firstBlackHoleCol) {
                                galaxy[firstBlackHoleRow][firstBlackHoleCol] = '-';
                                galaxy[secondBlackHoleRow][secondBlackHoleCol] = 'S';
                                playerRow = secondBlackHoleRow;
                                playerCol = secondBlackHoleCol;
                            } else if (playerRow== secondBlackHoleRow && playerCol - 1 == secondBlackHoleCol) {
                                galaxy[secondBlackHoleRow][secondBlackHoleCol] = '-';
                                galaxy[firstBlackHoleRow][firstBlackHoleCol] = 'S';
                                playerRow = firstBlackHoleRow;
                                playerCol = firstBlackHoleCol;
                            }
                        } else {
                            galaxy[playerRow][playerCol - 1] = 'S';
                            playerCol -= 1;
                        }
                    } else {
                        galaxy[playerRow][playerCol] = '-';
                        isIn = false;
                        break;
                    }
                    break;
            }
        }


        if (!isIn) {
            System.out.println("Bad news, the spaceship went to the void.");
        } else {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }
        System.out.println("Star power collected: " + energy);

        printMatrix(galaxy);
    }

    private static void printMatrix(char[][] galaxy) {
        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                System.out.print(galaxy[i][j]);
            }
            System.out.println();
        }
    }
}
