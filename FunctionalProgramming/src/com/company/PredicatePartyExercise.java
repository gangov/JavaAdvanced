package com.company;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/*
The Wire’s parents are on a vacation for the holidays and he is planning an epic party at home. Unfortunately, his
organizational skills are next to non-existent so you are given the task to help him with the reservations.
On the first line you get a list with all the people that are coming. On the next lines, until you get the "Party!"
command, you may be asked to double or remove all the people that apply to given criteria. There are three different
options:
Everyone that has a name starting with a given string;
Everyone that has a name ending with a given string;
Everyone that has a name with a given length.
When you print the guests that are coming to the party, you have to print them in asscending order. If nobody is going,
print "Nobody is going to the party!". See the examples below:
 */
public class PredicatePartyExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        BiPredicate<String, String> startWith = String::startsWith;
        BiPredicate<String, String> endWith = String::endsWith;
        BiPredicate<String, String> length = (e, l) -> e.length() == Integer.parseInt(l);

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] company = input.split("\\s+");

            if (company[0].equals("Remove")) {
                switch (company[1]) {
                    case "StartsWith":
                        names = names.stream().filter(e -> !startWith.test(e, company[2])).collect(Collectors.toList());
                        break;
                    case "EndsWith":
                        names = names.stream().filter(e -> !endWith.test(e, company[2])).collect(Collectors.toList());
                        break;
                    case "Length":
                        names = names.stream().filter(e -> !length.test(e, company[2])).collect(Collectors.toList());
                        break;
                }
            } else {
                switch (company[1]) {
                    case "StartsWith":
                        doubleByCriteria(startWith, names, company[2]);
                        break;
                    case "EndsWith":
                        doubleByCriteria(endWith, names, company[2]);
                        break;
                    case "Length":
                        doubleByCriteria(length, names, company[2]);
                        break;

                }
            }

            input = scanner.nextLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.println(names.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
        }
    }


    private static void doubleByCriteria(BiPredicate<String, String> function, List<String> names, String s) {
        for (int i = 0; i < names.size(); i++) {
            if (function.test(names.get(i), s)) {
                names.add(i, names.get(i));
                ++i;
            }
        }
    }
}
