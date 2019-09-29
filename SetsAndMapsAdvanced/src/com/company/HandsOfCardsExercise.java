package com.company;

import java.util.*;
import java.util.stream.Collectors;

/*
You are given a sequence of people and for every person what cards he draws from the deck. The input will be separate
lines in the format:
{personName}: {PT, PT, PT,… PT}
Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type. The input
ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ':'. The input will always be valid and in
the format described, there is no need to check it.
A single person cannot have more than one card with the same power and type, if he draws such a card he discards it.
The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by the
type. Powers 2 to 10 have the same value and J to A are 11 to 14. Types are mapped to multipliers the following way
(S -> 4, H-> 3, D -> 2, C -> 1).
Finally print out the total value each player has in his hand in the format:
{personName}: {value}
 */
public class HandsOfCardsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, ArrayList<String>> results = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            ArrayList<String> fixCards = new ArrayList<>();
            fixCards = (ArrayList<String>) Arrays.stream(tokens[1].split(", ")).collect(Collectors.toList());
            ArrayList<String> noDupCards = (ArrayList<String>) removeDuplicates(fixCards);


            if (results.containsKey(name)) {
                for (String noDupCard : noDupCards) {
                    if (!results.get(name).contains(noDupCard))
                        results.get(name).add(noDupCard);
                }
            }
            results.putIfAbsent(name, new ArrayList<>(noDupCards));

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> nameAndAllCards : results.entrySet()) {
            String name = nameAndAllCards.getKey();
            ArrayList<String> cards = nameAndAllCards.getValue();
            int score = 0;

            for (String card : cards) {
                int power = 0;
                int type = 0;
                String cardP = "";
                String cardT = "";
                if (card.length() <= 2) {
                    cardP = String.valueOf(card.charAt(0));
                    cardT = String.valueOf(card.charAt(1));
                } else {
                    cardP = card.substring(0, 2);
                    cardT = String.valueOf(card.charAt(2));
                }

                switch (cardP) {
                    case "2":
                        power = 2;
                        break;
                    case "3":
                        power = 3;
                        break;
                    case "4":
                        power = 4;
                        break;
                    case "5":
                        power = 5;
                        break;
                    case "6":
                        power = 6;
                        break;
                    case "7":
                        power = 7;
                        break;
                    case "8":
                        power = 8;
                        break;
                    case "9":
                        power = 9;
                        break;
                    case "10":
                        power = 10;
                        break;
                    case "J":
                        power = 11;
                        break;
                    case "Q":
                        power = 12;
                        break;
                    case "K":
                        power = 13;
                        break;
                    case "A":
                        power = 14;
                        break;
                }

                switch (cardT) {
                    case "S":
                        type = 4;
                        break;
                    case "H":
                        type = 3;
                        break;
                    case "D":
                        type = 2;
                        break;
                    case "C":
                        type = 1;
                        break;
                }

                int total = power * type;
                score += total;
            }
            System.out.printf("%s: %d%n", name, score);
        }
    }

    private static List<String> removeDuplicates(List<String> cardsRaw) {
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < cardsRaw.size(); i++) {
            if (!newList.contains(cardsRaw.get(i))) {
                newList.add(cardsRaw.get(i));
            }
        }

        return newList;
    }
}
