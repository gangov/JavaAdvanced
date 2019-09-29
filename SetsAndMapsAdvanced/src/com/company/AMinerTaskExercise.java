package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
You are given a sequence of strings, each on a new line. Every odd line on the console is representing a resource
(e.g. Gold, Silver, Copper, and so on) , and every even – quantity. Your task is to collect the resources and print
them each on a new line.
Print the resources and their quantities in format:
{resource} –> {quantity}
The quantities inputs will be in the range [1 … 2 000 000 000]
 */
public class AMinerTaskExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        int counter = 0;

        ArrayList<String> resourceName = new ArrayList<>();
        ArrayList<Integer> resourceQuantity = new ArrayList<>();


        while (!input.equals("stop")) {
            if (counter % 2 == 0) {
                resourceName.add(input);
            } else {
                resourceQuantity.add(Integer.parseInt(input));
            }

            counter++;
            input = scanner.nextLine();
        }

        for (int i = 0; i < resourceName.size(); i++) {
            String name = resourceName.get(i);
            int quantity = resourceQuantity.get(i);
            if (resources.containsKey(name)) {
                resources.put(name, resources.get(name) + quantity);
            }
            resources.putIfAbsent(name, quantity);
        }

        for (Map.Entry<String, Integer> resourceAndQuantity : resources.entrySet()) {
            String resource = resourceAndQuantity.getKey();
            int quantity = resourceAndQuantity.getValue();

            System.out.printf("%s -> %d%n", resource, quantity);
        }
    }
}
