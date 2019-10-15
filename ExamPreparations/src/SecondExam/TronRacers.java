package SecondExam;

import java.util.Scanner;

/*
The new TRON tournament has started and you have to keep track of the players on the field.
You will be given an integer n for the size of the matrix. On the next n lines, you will receive the rows of the matrix.
The game starts with two players (first player is marked with "f" and the second player is marked with "s") in random
positions and all of the empty slots will be filled with "*".
Each turn you will be given commands respectively for each player’s movement. The first command is for the first player
and the second is for the second player. After a player moves, he leaves a trail on the field. The symbol that marks the
trail is the same as the player's symbol. If a player goes out of the matrix, he comes in from the other side. If a
player steps on the other player's trail, he dies. When a player dies in the field, you should write "x" in the position
where he died.
When only one of the players is left alive on the field the game ends.


Input
On the first line, you are given the integer N – the size of the square matrix.

The next N lines holds the values for every row.

On each of the next lines you will get two commands in the format up, down, left or right.


Output
In the end print the matrix.


Constraints
The size of the matrix will be between [2…20].
There will always be exactly two players.
The players will always be indicated with "f" for the first one and "s" for the second one.
There will always be enough commands to finish the game with one player alive.
There will not be commands where a player goes back and steps on his trail from the previous turn.
 */
public class TronRacers {
    static boolean oneAlive = true;
    static boolean twoAlive = true;
    static int firstRow = -1;
    static int firstCol = -1;
    static int secondRow = -1;
    static int secondCol = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];


        for (int rows = 0; rows < matrix.length; rows++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[rows] = input;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == 'f') {
                    firstRow = rows;
                    firstCol = i;
                } else if (input[i] == 's') {
                    secondRow = rows;
                    secondCol = i;
                }
            }
        }

        while (oneAlive && twoAlive) {
            String[] commands = scanner.nextLine().split("\\s+");
            String oneMove = commands[0];
            movePlayerOne(matrix, firstRow, firstCol, oneMove);
            if (oneAlive) {
                String twoMove = commands[1];
                movePlayerTwo(matrix, secondRow, secondCol, twoMove);
            }
        }
        printMatrix(matrix);
    }

    private static char[][] movePlayerTwo(char[][] matrix, int playerTwoRow, int playerTwoCol, String twoMove) {
        switch (twoMove) {
            case "up":
                if (playerTwoRow - 1 < 0) {
                    if (matrix[matrix.length - 1][playerTwoCol] != 'f') {
                        matrix[matrix.length - 1][playerTwoCol] = 's';
                        secondRow = matrix.length - 1;
                    } else {
                        matrix[matrix.length - 1][playerTwoCol] = 'x';
                        twoAlive = false;
                    }
                } else {
                    if (matrix[playerTwoRow - 1][playerTwoCol] != 'f') {
                        matrix[playerTwoRow - 1][playerTwoCol] = 's';
                        secondRow = playerTwoRow - 1;
                    } else {
                        matrix[playerTwoRow - 1][playerTwoCol] = 'x';
                        twoAlive = false;
                    }
                }
                break;

            case "down":
                if (playerTwoRow + 1 >= matrix.length) {
                    if (matrix[0][playerTwoCol] != 'f') {
                        matrix[0][playerTwoCol] = 's';
                        secondRow = 0;
                    } else {
                        matrix[0][playerTwoCol] = 'x';
                        twoAlive = false;
                    }
                } else {
                    if (matrix[playerTwoRow + 1][playerTwoCol] != 'f') {
                        matrix[playerTwoRow + 1][playerTwoCol] = 's';
                        secondRow = playerTwoRow + 1;
                    } else {
                        matrix[playerTwoRow + 1][playerTwoCol] = 'x';
                        twoAlive = false;
                    }
                }
                break;

            case "left":
                if (playerTwoCol - 1 < 0) {
                    if (matrix[playerTwoRow][matrix.length - 1] != 'f') {
                        matrix[playerTwoRow][matrix.length - 1] = 's';
                        secondCol = matrix.length - 1;
                    } else {
                        matrix[playerTwoRow][matrix.length - 1] = 'x';
                        twoAlive = false;
                    }
                } else {
                    if (matrix[playerTwoRow][playerTwoCol - 1] != 'f') {
                        matrix[playerTwoRow][playerTwoCol - 1] = 's';
                        secondCol = playerTwoCol - 1;
                    } else {
                        matrix[playerTwoRow][playerTwoCol - 1] = 'x';
                        twoAlive = false;
                    }
                }

                break;

            case "right":
                if (playerTwoCol + 1 >= matrix.length) {
                    if (matrix[playerTwoRow][0] != 'f') {
                        matrix[playerTwoRow][0] = 's';
                        secondCol = 0;
                    } else {
                        matrix[playerTwoRow][0] = 'x';
                        twoAlive = false;
                    }
                } else {
                    if (matrix[playerTwoRow][playerTwoCol + 1] != 'f') {
                        matrix[playerTwoRow][playerTwoCol + 1] = 's';
                        secondCol = playerTwoCol + 1;
                    } else {
                        matrix[playerTwoRow][playerTwoCol + 1] = 'x';
                        twoAlive = false;
                    }
                }
                break;
        }
        return matrix;
    }

    private static char[][] movePlayerOne(char[][] matrix, int playerOneRow, int playerOneCol, String movement) {
        switch (movement) {
            case "up":
                if (playerOneRow - 1 < 0) {
                    if (matrix[matrix.length - 1][playerOneCol] != 's') {
                        matrix[matrix.length - 1][playerOneCol] = 'f';
                        firstRow = matrix.length - 1;
                    } else {
                        matrix[matrix.length - 1][playerOneCol] = 'x';
                        oneAlive = false;
                    }
                } else {
                    if (matrix[playerOneRow - 1][playerOneCol] != 's') {
                        matrix[playerOneRow - 1][playerOneCol] = 'f';
                        firstRow = playerOneRow - 1;
                    } else {
                        matrix[playerOneRow - 1][playerOneCol] = 'x';
                        oneAlive = false;
                    }
                }
                break;

            case "down":
                if (playerOneRow + 1 >= matrix.length) {
                    if (matrix[0][playerOneCol] != 's') {
                        matrix[0][playerOneCol] = 'f';
                        firstRow = 0;
                    } else {
                        matrix[0][playerOneCol] = 'x';
                        oneAlive = false;
                    }
                } else {
                    if (matrix[playerOneRow + 1][playerOneCol] != 's') {
                        matrix[playerOneRow + 1][playerOneCol] = 'f';
                        firstRow = playerOneRow + 1;
                    } else {
                        matrix[playerOneRow + 1][playerOneCol] = 'x';
                        oneAlive = false;
                    }
                }
                break;

            case "left":
                if (playerOneCol - 1 < 0) {
                    if (matrix[playerOneRow][matrix.length - 1] != 's') {
                        matrix[playerOneRow][matrix.length - 1] = 'f';
                        firstCol = matrix.length - 1;
                    } else {
                        matrix[playerOneRow][matrix.length - 1] = 'x';
                        oneAlive = false;
                    }
                } else {
                    if (matrix[playerOneRow][playerOneCol - 1] != 's') {
                        matrix[playerOneRow][playerOneCol - 1] = 'f';
                        firstCol = playerOneCol - 1;
                    } else {
                        matrix[playerOneRow][playerOneCol - 1] = 'x';
                        oneAlive = false;
                    }
                }

                break;

            case "right":
                if (playerOneCol + 1 >= matrix.length) {
                    if (matrix[playerOneRow][0] != 's') {
                        matrix[playerOneRow][0] = 'f';
                        firstCol = 0;
                    } else {
                        matrix[playerOneRow][0] = 'x';
                        oneAlive = false;
                    }
                } else {
                    if (matrix[playerOneRow][playerOneCol + 1] != 's') {
                        matrix[playerOneRow][playerOneCol + 1] = 'f';
                        firstCol = playerOneCol + 1;
                    } else {
                        matrix[playerOneRow][playerOneCol + 1] = 'x';
                        oneAlive = false;
                    }
                }
                break;
        }

        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
