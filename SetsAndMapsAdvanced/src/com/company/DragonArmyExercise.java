package com.company;

import java.util.*;

/*
Heroes III is the best game ever. Everyone loves it and everyone plays it all the time. Stamat is no exclusion to this
rule. His favorite units in the game are all types of dragons – black, red, gold, azure etc… He likes them so much that
he gives them names and keeps logs of their stats: damage, health and armor. The process of aggregating all the data is
quite tedious, so he would like to have a program doing it. Since he is no programmer, it’s your task to help him
You need to categorize dragons by their type. For each dragon, identified by name, keep information about his stats.
Type is preserved as in the order of input, but dragons are sorted alphabetically by name. For each type, you should
also print the average damage, health and armor of the dragons. For each dragon, print his own stats.
There may be missing stats in the input, though. If a stat is missing you should assign it default values. Default
values are as follows: health 250, damage 45, and armor 10. Missing stat will be marked by null.
The input is in the following format {type} {name} {damage} {health} {armor}. Any of the integers may be assigned null
value. See the examples below for better understanding of your task.
If the same dragon is added a second time, the new stats should overwrite the previous ones. Two dragons are considered
equal if they match by both name and type.

Input
On the first line, you are given number N -> the number of dragons to follow
On the next N lines you are given input in the above described format. There will be single space separating each
element.

Output
Print the aggregated data on the console
For each type, print average stats of its dragons in format {Type}::({damage}/{health}/{armor})
Damage, health and armor should be rounded to two digits after the decimal separator
For each dragon, print its stats in format -{Name} -> damage: {damage}, health: {health}, armor: {armor}

Constraints
N is in range [1…100]
The dragon type and name are one word only, starting with capital letter.
Damage health and armor are integers in range [0 … 100000] or null
 */
public class DragonArmyExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();


        for (int i = 0; i < count; i++) {
            //default values
            String damage = "45";
            String health = "250";
            String armor = "10";

            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            if (!input[2].equals("null")) {
                damage = input[2];
            }
            if (!input[3].equals("null")) {
                health = input[3];
            }
            if (!input[4].equals("null")) {
                armor = input[4];
            }

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, new int[]{Integer.parseInt(damage), Integer.parseInt(health), Integer.parseInt(armor)});
        }

        dragons.entrySet().stream().forEach(pair -> {
            double avgDmg = pair.getValue().values().stream().mapToDouble(num -> num[0]).sum() / pair.getValue().values().size();
            double avgHlth = pair.getValue().values().stream().mapToDouble(num -> num[1]).sum() / pair.getValue().values().size();
            double avgArmr = pair.getValue().values().stream().mapToDouble(num -> num[2]).sum() / pair.getValue().values().size();

            System.out.println(String.format("%s:: (%.2f/%.2f/%.2f)", pair.getKey(), avgDmg, avgHlth, avgArmr));
            pair.getValue().entrySet().stream().forEach(beast -> {
                System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d", beast.getKey()
                        , beast.getValue()[0]
                        , beast.getValue()[1]
                        , beast.getValue()[2]));
            });
        });
    }
}
