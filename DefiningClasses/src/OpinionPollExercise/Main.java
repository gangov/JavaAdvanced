package OpinionPollExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Create Person class with two fields String name and int age, write a program that reads from the console N lines of
personal information and then prints all people whose age is more than 30 years, sorted in alphabetical order.
Note: you can use stream() to filter people.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            people.put(person.getName(), person.getAge());
        }

        people.entrySet().stream().filter(p -> p.getValue() > 30).sorted((e1, e2) -> {
            return e1.getKey().compareTo(e2.getKey());
        }).forEach(p -> System.out.println(String.format("%s - %d", p.getKey(), p.getValue())));
    }
}
