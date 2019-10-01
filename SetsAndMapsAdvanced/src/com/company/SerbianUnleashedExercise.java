package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

/*
Admit it – the СРЪБСКО is your favorite sort of music. You never miss a concert and you have become quite the geek
concerning everything involved with СРЪБСКО. You can’t decide between all the singers you know who your favorite one is.
One way to find out is to keep a statistics of how much money their concerts make. Write a program that does all the
boring calculations for you.
On each input line you’ll be given data in format: "singer @venue ticketsPrice ticketsCount". There will be no redundant
whitespaces anywhere in the input. Aggregate the data by venue and by singer. For each venue, print the singer and the
total amount of money his/her concerts have made on a separate line. Venues should be kept in the same order they were
entered, the singers should be sorted by how much money they have made in descending order. If two singers have made the
same amount of money, keep them in the order in which they were entered.
Keep in mind that if a line is in incorrect format, it should be skipped and its data should not be added to the output.
Each of the four tokens must be separated by a space, everything else is invalid. The venue should be denoted with @ in
front of it, such as @Sunny Beach
SKIP THOSE: Ceca@Belgrade125 12378, Ceca @Belgrade12312 123
The singer and town name may consist of one to three words.

Input
The input data should be read from the console.
It consists of a variable number of lines and ends when the command “End" is received.
The input data will always be valid and in the format described. There is no need to check it explicitly.

Output
The output should be printed on the console.
Print the aggregated data for each venue and singer in the format shown below.
Format for singer lines is #{2*space}{singer}{space}->{space}{total money}

Constraints
The number of input lines will be in the range [2 … 50].
The ticket price will be an integer in the range [0 … 200].
The ticket count will be an integer in the range [0 … 100 000]
Singers and venues are case sensitive
Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.
 */
public class SerbianUnleashedExercise {
    static String singer = "";
    static String location = "";
    static ArrayList<Integer> priceAndCount = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> koncerts = new LinkedHashMap<>();

        while (!input.equals("End")) {
            if (checkIfValidInput(input)) {
                int count = priceAndCount.get(0);
                int price = priceAndCount.get(priceAndCount.size() - 1);
                int profit = count * price;
                koncerts.putIfAbsent(location, new LinkedHashMap<>());
                koncerts.get(location).putIfAbsent(singer, 0);
                koncerts.get(location).put(singer, koncerts.get(location).get(singer) + profit);
                priceAndCount.clear();
            }

            input = scanner.nextLine();
        }


        koncerts.entrySet().stream().forEach(pair -> {
            System.out.println(pair.getKey());
            pair.getValue().entrySet().stream().sorted((first, second) -> {
                if (first.getValue().equals(second.getValue())) {
                    return first.getValue().compareTo(second.getValue());
                }
                return second.getValue().compareTo(first.getValue());
            })
            .forEach(i -> {
                System.out.println(String.format("#  %s -> %d", i.getKey(), i.getValue()));
            });
        });
    }

    private static boolean checkIfValidInput(String input) {
        int firstSpace = 0;
        boolean isValid = false;
        String[] tokens = input.split("@");
        String performer = tokens[0];
        String rightTokens = tokens[1];
        if (performer.charAt(performer.length() - 1) == ' ') {
            isValid = true;
            singer = performer.substring(0, performer.length() - 1);
        }
        String[] restInfo = tokens[1].split(" ");
        for (int i = restInfo.length - 1; i >= restInfo.length - 2; i--) {
            isValid = isNumeric(restInfo[i]);
            if (isNumeric(restInfo[i])) {
                priceAndCount.add(Integer.parseInt(restInfo[i]));
            }
        }

        if (isValid) {
            for (int i = 0; i < rightTokens.length(); i++) {
                if (rightTokens.charAt(i) == ' ' && Character.isDigit(rightTokens.charAt(i + 1))) {
                    firstSpace = i;
                    break;
                }
            }
            location = rightTokens.substring(0, firstSpace);
        }

        return isValid;
    }

    private static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
