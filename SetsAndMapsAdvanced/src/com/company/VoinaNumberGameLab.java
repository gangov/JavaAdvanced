package com.company;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

/*
Write program that:
Reads 20 numbers for both players, separated with " " (single space)
Every player can hold only unique numbers
Each Round both players get the top number from their own deck. Player with the bigger number get both numbers and add
it on the bottom of his own sequence
Game ends after 50 rounds or if any player lose all of his numbers
Input
Numbers – Integer
Input
Output must be "First Player Win!", "Second Player Win!" or "Draw!"
 */
public class VoinaNumberGameLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] onePlayer = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] twoPlayer = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<Integer> firstDeck = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondDeck = new LinkedHashSet<>();

        for (Integer integer : onePlayer) {
            firstDeck.add(integer);
        }
        for (Integer integer : twoPlayer) {
            secondDeck.add(integer);
        }

        for (int i = 0; i < 50; i++) {

            int playerOnePlays = firstDeck.iterator().next();
            firstDeck.remove(playerOnePlays);
            int playerTwoPlays = secondDeck.iterator().next();
            secondDeck.remove(playerTwoPlays);

            if (playerOnePlays > playerTwoPlays) {
                firstDeck.add(playerOnePlays);
                firstDeck.add(playerTwoPlays);
            } else if (playerTwoPlays > playerOnePlays){
                secondDeck.add(playerOnePlays);
                secondDeck.add(playerTwoPlays);
            } else {
                firstDeck.add(playerOnePlays);
                secondDeck.add(playerTwoPlays);
            }

            if (firstDeck.isEmpty()) {
                System.out.println("Second player win!");
                break;
            } else if (secondDeck.isEmpty()) {
                System.out.println("First player win!");
                break;
            }
        }

        if (firstDeck.size() < secondDeck.size()) {
            System.out.println("Second player win!");
        } else if (secondDeck.size() < firstDeck.size()){
            System.out.println("First player win!");
        }
        if (secondDeck.size() == firstDeck.size()) {
            System.out.println("Draw!");
        }

    }
}
