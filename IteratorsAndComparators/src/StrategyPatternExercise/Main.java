package StrategyPatternExercise;

import java.util.Scanner;
import java.util.TreeSet;

/*
An interesting pattern you may have heard of is the Strategy Pattern, if we have multiple ways to do a task (let's say
sort a collection) it allows the client to choose the way that most fits his needs. A famous implementation of the
pattern in Java is the Collections.sort() method that takes a Comparator.
Create a class Person that holds name and age. Create 2 Comparators for Person (classes which implement the
Comparator<Person> interface). The first comparator should compare people based on the length of their name as a first
parameter, if 2 people have a name with the same length, perform a case-insensitive compare based on the first letter of
their name instead. The second comparator should compare them based on their age. Create 2 TreeSets of type Person, the
first should implement the name comparator and the second should implement the age comparator.


Input
On the first line of input you will receive a number N. On each of the next N lines you will receive information about
people in the format "<name> <age>". Add the people from the input into both sets (both sets should hold all the people
passed in from the input).


Output
Foreach the sets and print each person from the set on a new line in the same format that you received them. Start with
the set that implements the name comparator.


Constraints
A person’s name will be a string that contains only alphanumerical characters with a length between [1…50] symbols.
A person’s age will be a positive integer between [1…100].
The number of people N will be a positive integer between [0…100].
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> names = new TreeSet<>(new CompareNames());
        TreeSet<Person> ages = new TreeSet<>(new CompareAges());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            names.add(person);
            ages.add(person);
        }

        names.forEach(System.out::println);
        ages.forEach(System.out::println);
    }
}