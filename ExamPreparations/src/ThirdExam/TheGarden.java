package ThirdExam;

import java.util.Scanner;

/*
Create a program that helps you harvest vegetables. There are three kinds of vegetables in your garden:
Lettuce  – 'L', Potatoes – 'P', Carrots  – 'C'
First, you will receive the rows of the garden. Then for each row, you will receive the vegetables, separated by space
in the following format:
"{vegetable1} {vegetable2} {vegetable3}… {vegetablen}"
Then you will start receiving commands. Here are the possible ones you can receive:
"Harvest {row} {col}" – you must go to the given place in the garden and harvest the vegetable, if it exists. When you
harvest a vegetable, you leave an empty space in the cell – ' '. Keep in mind, that you can't harvest a vegetable, which
was already harvested or harmed.
"Mole {row} {col} {direction}" – there is a mole in that cell and it goes in that direction, which means the mole, goes
from this cell until the last cell in the given direction. It harms the given cell, skips the next, and harms the next
one, an so on until the last cell. Mark the harmed cells with a space - ' '. Keep in mind, that you can't harm a
vegetable, that was already harmed or harvested. There are four possible directions:
"Up", "Down", "Left", "Right"
"End of Harvest" – ends the input.
Here is an example of the mole's harm radius:

In the end, print the resulting garden. The cells must be separated by a space. Then print the vegetbles you have
succesfully harvested and the count of harmed vegetables you have found in the following format:
"Carrots: {countOfCarrots}
Potatos: {countOfPotatos}
Lettuce: {countOfCucmbers}
Harmed vegetables: {count}"


Input / Constraints
On the first line, you will receive the count of rows.
On the next lines, for each row, you will receive the vegetables in the described format.
Next, until you receive "End of Harvest", you will be receiving commands in the described format.
The input will always be valid and you don't need to check it explicitly.


Output
Print the resulting garden – each cell separated by a single space.
Print the harvested and harmed vegatables in the format described above.
 */
public class TheGarden {
    private static int harmedVegetables = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int lettuce = 0;
        int potatoes = 0;
        int carrots = 0;

        String[][] matrix = new String[n][100];

        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();
        while (!input.equals("End of Harvest")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Harvest":
                    int currentRow = Integer.parseInt(tokens[1]);
                    int currentCol = Integer.parseInt(tokens[2]);
                    if ((currentRow >= 0 && currentRow < matrix.length) && (currentCol >= 0 && currentCol < matrix[currentRow].length)) {
                        if (matrix[currentRow][currentCol].equals("L")) {
                            lettuce++;
                            matrix[currentRow][currentCol] = " ";
                        } else if (matrix[currentRow][currentCol].equals("P")) {
                            potatoes++;
                            matrix[currentRow][currentCol] = " ";
                        } if (matrix[currentRow][currentCol].equals("C")) {
                            carrots++;
                            matrix[currentRow][currentCol] = " ";
                        }
                    }
                    break;
                case "Mole":
                    int moleRow = Integer.parseInt(tokens[1]);
                    int moleCol = Integer.parseInt(tokens[2]);
                    String direction = tokens[3];
                    moveTheMole(matrix, moleRow, moleCol, direction);
                    break;
            }
            input = scanner.nextLine();
        }
        printMatrix(matrix);
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmedVegetables);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == matrix[i].length - 1) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static String[][] moveTheMole(String[][] matrix, int moleRow, int moleCol, String direction) {
        int row = moleRow;
        int col = moleCol;
        switch (direction) {
            case "up":
                try {
                    for (int i = row; i >= 0; i -= 2) {
                        if (!matrix[i][col].equals(" ")) {
                            harmedVegetables++;
                            matrix[i][col] = " ";
                        }
                    }
                    break;
                } catch (Exception ignored) {

                }
            case "down":
                try {
                    for (int i = row; i < matrix.length; i += 2) {
                        if (!matrix[i][col].equals(" ")) {
                            harmedVegetables++;
                            matrix[i][col] = " ";
                        }
                    }
                    break;
                } catch (Exception ignored) {

                }
            case "right":
                try {
                    for (int i = col; i < matrix[row].length; i += 2) {
                        if (!matrix[row][i].equals(" ")) {
                            harmedVegetables++;
                            matrix[row][i] = " ";
                        }
                    }
                    break;
                } catch (Exception ignored) {

                }

            case "left":
                try {
                    for (int i = col; i >= 0; i -= 2) {
                        if (!matrix[row][i].equals(" ")) {
                            harmedVegetables++;
                            matrix[row][i] = " ";
                        }
                    }
                    break;
                } catch (Exception ignored) {

                }

        }

        return matrix;
    }
}
