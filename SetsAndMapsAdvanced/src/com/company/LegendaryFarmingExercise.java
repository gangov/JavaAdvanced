package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
You’ve beaten all the content and the last thing left to accomplish is own a legendary item. However, it’s a tedious
process and requires quite a bit of farming. Anyway, you are not too pretentious – any legendary will do. The possible
items are:
Shadowmourne – requires 250 Shards;
Valanyr – requires 250 Fragments;
Dragonwrath – requires 250 Motes;
Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as  2 motes
3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point,
print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes, ordered by quantity in
descending order, each on a new line. Finally, print the collected junk items, in alphabetical order.

Input
Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}

Output
On the first line, print the obtained item in format {Legendary item} obtained!
On the next three lines, print the remaining key materials in descending order by quantity
If two key materials have the same quantity, print them in alphabetical order
On the final several lines, print the junk items in alphabetical order
All materials are printed in format {material}: {quantity}
All output should be lowercase, except the first letter of the legendary

Constraints
The quantity-material pairs are between 1 and 25 per line.
The number of lines is in range [1..10]
All materials are case-insensitive.
Allowed working time: 0.25s
Allowed memory: 16 MB
 */
public class LegendaryFarmingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> unique = new HashMap<>();
        unique.put("shards", 0);
        unique.put("motes", 0);
        unique.put("fragments", 0);
        TreeMap<String, Integer> junk = new TreeMap<>();

        boolean isValid = true;
        String winnerSword = "";

        int neededForShards = 0;
        int neededForMotes = 0;
        int neededForFragments = 0;

        String input = scanner.nextLine().toLowerCase();
        outer:
        while (true) {
            String[] tokens = input.split(" ");


            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String resource = tokens[i + 1];

                if (resource.equals("shards") || resource.equals("motes") || resource.equals("fragments")) {
                    unique.put(resource, unique.get(resource) + quantity);
                    switch (resource) {
                        case "shards":
                            neededForShards += quantity;
                            if (neededForShards >= 250) {
                                unique.put("shards", unique.get("shards") - 250);
                                System.out.println("Shadowmourne obtained!");
                                break outer;
                            }
                            break;
                        case "motes":
                            neededForMotes += quantity;
                            if (neededForMotes >= 250) {
                                unique.put("motes", unique.get("motes") - 250);
                                System.out.println("Dragonwrath obtained!");
                                break outer;
                            }
                            break;
                        case "fragments":
                            neededForFragments += quantity;
                            if (neededForFragments >= 250) {
                                unique.put("fragments", unique.get("fragments") - 250);
                                System.out.println("Valanyr obtained!");
                                break outer;
                            }
                            break;
                    }
                } else {
                    junk.putIfAbsent(resource, 0);
                    junk.put(resource, junk.get(resource) + quantity);
                }
            }

            input = scanner.nextLine().toLowerCase();
        }

        unique.entrySet().stream().sorted((e1, e2) -> {
            if (e2.getValue().equals(e1.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            } else {

                return e2.getValue().compareTo(e1.getValue());
            }
        }).forEach(pair -> {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        });
        junk.entrySet().stream().forEach(pair -> {
            System.out.println(String.format("%s: %d", pair.getKey(), pair.getValue()));
        });
    }
}
