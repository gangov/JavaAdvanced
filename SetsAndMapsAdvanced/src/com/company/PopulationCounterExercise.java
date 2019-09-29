package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
So many people! It’s hard to count them all. But that’s your job as a statistician. You get raw data for a given city
and you need to aggregate it.
On each input line you’ll be given data in format: "city|country|population". There will be no redundant whitespaces
anywhere in the input. Aggregate the data by country and by city and print it on the console. For each country, print
its total population and on separate lines the data for each of its cities. Countries should be ordered by their total
population in descending order and within each country, the cities should be ordered by the same criterion. If two
countries/cities have the same population, keep them in the order in which they were entered. Check out the examples;
follow the output format strictly!
Input
The input data should be read from the console.
It consists of a variable number of lines and ends when the command "report" is received.
The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
The output should be printed on the console.
Print the aggregated data for each country and city in the format shown below.
Constraints
The name of the city, country and the population count will be separated from each other by a pipe ('|').
The number of input lines will be in the range [2 … 50].
A city-country pair will not be repeated.
The population count of each city will be an integer in the range [0 … 2 000 000 000].
Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.
 */
public class PopulationCounterExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> counterPopulation = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            counterPopulation.putIfAbsent(country, new LinkedHashMap<>());
            if (counterPopulation.containsKey(country)) {
                counterPopulation.get(country).putIfAbsent(city, population);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> countryAndCity : counterPopulation.entrySet()) {
            String country = countryAndCity.getKey();
            LinkedHashMap<String, Integer> cityAndPopulation = countryAndCity.getValue();
            int totalPopulation = 0;

            for (Map.Entry<String, Integer> cityAndPopulationEntrySet : cityAndPopulation.entrySet()) {
                String currentCity = cityAndPopulationEntrySet.getKey();
                Integer currentPopulation = cityAndPopulationEntrySet.getValue();
                totalPopulation += currentPopulation;
            }
            System.out.printf("%s (total population: %d)%n", country, totalPopulation);

            for (Map.Entry<String, Integer> cityAndPopulationEntrySet : cityAndPopulation.entrySet()) {
                String currentCity = cityAndPopulationEntrySet.getKey();
                Integer currentPopulation = cityAndPopulationEntrySet.getValue();
                System.out.printf("=>%s: %d%n", currentCity, currentPopulation);
                totalPopulation += currentPopulation;
            }
        }
    }
}
