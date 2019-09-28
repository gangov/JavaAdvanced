package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
Write a program to read continents, countries and their cities, put them in a nested map and print them in the order
of first appearance.
 */
public class CitiesbyContinentandCountryLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> allData = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continents = input[0];
            String countries = input[1];
            String cities = input[2];

            allData.putIfAbsent(continents, new LinkedHashMap<String, ArrayList<String>>());
            allData.get(continents).putIfAbsent(countries, new ArrayList<>());
            allData.get(continents).get(countries).add(cities);
        }

        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> allDataSet : allData.entrySet()) {
            String continent = allDataSet.getKey();
            LinkedHashMap<String, ArrayList<String>> countriesAndCities = allDataSet.getValue();

            System.out.println(continent + ":");
            for (Map.Entry<String, ArrayList<String>> countryAndCitySet : countriesAndCities.entrySet()) {
                String country = countryAndCitySet.getKey();
                ArrayList<String> cities = countryAndCitySet.getValue();
                System.out.printf("  %s -> ", country);
                // TODO: 28.09.19 why is this not working
//                cities.forEach(city -> {
//                    if (cities.indexOf(city) == (cities.size()) - 1) {
//                        System.out.printf("%s%n", city);
//                    } else {
//                        System.out.printf("%s, ", city);
//                    }
//                });

                System.out.print(String.join(", ", cities));
                System.out.println();
            }
        }
    }
}
