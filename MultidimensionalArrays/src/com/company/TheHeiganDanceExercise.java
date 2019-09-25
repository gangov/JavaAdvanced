package com.company;

import java.util.Scanner;

/*
At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped by the
famous dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague Clouds and
Eruptions, and you’ll be just fine.
Heigan’s chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn,
Heigan uses a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1), he also
hits (0,0, 0,1, 0,2, 1,0 … 2,2). If the player’s current position is within the area of damage, the player tries to
move. First, he tries to move up, if there’s damage/wall, he tries to move right, then down, then left. If he cannot
move in any direction, because the cell is damaged or there is a wall, the player stays in place and takes the damage.
Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000 damage
when it hits. If a spell hits a player that also has an active Plague Cloud from the previous turn, the cloud damage is
applied first. Both Heigan and the player may die in the same turn. If Heigan is dead, the spell he would have casted
is ignored.
The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does damage
to Heigan. The fight is over either when the player is killed, or Heigan is defeated.

Input
On the first line you receive a floating-point number D – the damage done to Heigan each turn
On the next several lines – you receive input in format {spell} {row} {col} – {spell} is either Cloud or Eruption

Output
    On the first line
If Heigan is defeated: “Heigan: Defeated!”
Else: “Heigan: {remaining}”, where remaining is rounded to two digits after the decimal separator
    On the second line:
If the player is killed: “Player: Killed by {spell}”
Else “Player: {remaining}”
    On the third line: “Final position: {row,  col}” -> the last coordinates of the player

Constraints
D is a floating-point number in range [0 … 500000]
A damaging spell will always affect at least one cell
Allowed memory: 16 MB
Allowed working time: 0.25s
 */
public class TheHeiganDanceExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //initializing the matrix and adding the player in it. This has a map so we can better debug
        String[][] matrix = new String[15][15];
        int[] playerLocation = new int[]{7, 7};
        matrixBuilder(matrix, playerLocation);
        matrix[playerLocation[0]][playerLocation[1]] = " O ";

        // player health and damage
        double playerHealth = 18500.00;
        double damage = Double.parseDouble(scanner.nextLine());

        // Heigan health
        double heiganHealth = 3000000.00;

        String lastAttack = "";
        boolean wasAvoided = false;
//        int turn = 1;                                                 ENABLE THIS IS IF YOU WANT UI DEBUGGING

        while (true) {
            if (lastAttack.equals("Cloud") && wasAvoided) {
                playerHealth -= 3500;
            }
//            System.out.println("Turn: " + turn++);                    ENABLE THIS IS IF YOU WANT UI DEBUGGING
            String[] heiganMove = scanner.nextLine().split(" ");
            String attack = heiganMove[0];
            int row = Integer.parseInt(heiganMove[1]);
            int col = Integer.parseInt(heiganMove[2]);

            damageDealing(matrix, attack, row, col);
//            printDungeon(matrix, playerLocation);                     ENABLE THIS IS IF YOU WANT UI DEBUGGING
            if (ifWithinArea(matrix, playerLocation)) {
                wasAvoided = false;
                if (!canAvoid(matrix, playerLocation)) {
                    wasAvoided = true;
                    if (attack.equals("Cloud")) {
                        playerHealth -= 3500;
                    } else if (attack.equals("Eruption")) {
                        playerHealth -= 6000;
                    }
                }
            }
            matrixBuilder(matrix, playerLocation);
            heiganHealth -= damage;
            if (playerHealth <= 0) {
                System.out.println(String.format("Heigan: %.2f", heiganHealth));
                if (attack.equals("Cloud")) {
                    attack = "Plague Cloud";
                }
                System.out.println("Player: Killed by " + attack);
                System.out.println("Final position: " + playerLocation[0] + ", " + playerLocation[1]);
                break;
            } else if (heiganHealth <= 0) {
                System.out.println("Heigan: Defeated!");
                System.out.println("Player: " + (int) playerHealth);
                System.out.println("Final position: " + playerLocation[0] + ", " + playerLocation[1]);
                break;
            }
            lastAttack = attack;
//            System.out.println("- - - - - - - - - - - - - - - - -");  ENABLE THIS IS IF YOU WANT UI DEBUGGING
        }

    }

    private static boolean canAvoid(String[][] matrix, int[] playerLocation) {
        if (matrix[playerLocation[0] - 1][playerLocation[1]].equals("[ ]") && playerLocation[0] - 1 <= 0) { // checks up
            playerLocation[0] -= 1;
            return true;
        } else if (matrix[playerLocation[0]][playerLocation[1] + 1].equals("[ ]") && playerLocation[1] + 1 < 15) { // checks right
            playerLocation[1] += 1;
            return true;
        } else if (matrix[playerLocation[0] + 1][playerLocation[1]].equals("[ ]") && playerLocation[0] + 1 < 15) { // checks down
            playerLocation[0] += 1;
            return true;
        } else if (matrix[playerLocation[0]][playerLocation[1] - 1].equals("[ ]") && playerLocation[1] - 1 <= 0) { // checks left
            playerLocation[1] -= 1;
            return true;
        } else { // if no move - taking damage
            return false;
        }
    }

    private static boolean ifWithinArea(String[][] matrix, int[] playerLocation) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals(" X ") && playerLocation[0] == row && playerLocation[1] == col) {
                    matrix[row][col] = " O ";
                    return true;
                }
            }
        }

        return false;
    }

    private static String[][] damageDealing(String[][] matrix, String attack, int row, int col) {
        if (attack.equals("Cloud")) {
            if (row - 1 >= 0 && col - 1 >= 0) {
                matrix[row - 1][col - 1] = " X ";
            }
            if (row - 1 >= 0) {
                matrix[row - 1][col] = " X ";
            }
            if (row - 1 >= 0 && col + 1 < 15) {
                matrix[row - 1][col + 1] = " X ";
            }
            if (col - 1 >= 0) {
                matrix[row][col - 1] = " X ";
            }
            matrix[row][col] = " X ";
            if (col + 1 < 15) {
                matrix[row][col + 1] = " X ";
            }
            if (row + 1 < 15 && col - 1 >= 0) {
                matrix[row + 1][col - 1] = " X ";
            }
            if (row + 1 < 15) {
                matrix[row + 1][col] = " X ";
            }
            if (row + 1 < 15 && col + 1 < 15) {
                matrix[row + 1][col + 1] = " X ";
            }



        } else if (attack.equals("Eruption")) {
            if (row - 1 >= 0 && col - 1 >= 0) {
                matrix[row - 1][col - 1] = " X ";
            }
            if (row - 1 >= 0) {
                matrix[row - 1][col] = " X ";
            }
            if (row - 1 >= 0 && col + 1 < 15) {
                matrix[row - 1][col + 1] = " X ";
            }
            if (col - 1 >= 0) {
                matrix[row][col - 1] = " X ";
            }
            matrix[row][col] = " X ";
            if (col + 1 < 15) {
                matrix[row][col + 1] = " X ";
            }
            if (row + 1 < 15 && col - 1 >= 0) {
                matrix[row + 1][col - 1] = " X ";
            }
            if (row + 1 < 15) {
                matrix[row + 1][col] = " X ";
            }
            if (row + 1 < 15 && col + 1 < 15) {
                matrix[row + 1][col + 1] = " X ";
            }


        }

        return matrix;
    }

    private static void printDungeon(String[][] matrix, int[] playerlocation) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == playerlocation[0] && col == playerlocation[1]) {
                    System.out.print(" O  ");;
                } else {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static String[][] matrixBuilder(String[][] matrix, int[] playerlocation) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = "[ ]";
            }
        }
        matrix[playerlocation[0]][playerlocation[1]] = " O ";
        return matrix;
    }
}
