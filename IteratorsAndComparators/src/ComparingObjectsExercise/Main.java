package ComparingObjectsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
There is a Comparable interface but probably you already know. Your task is simple. Create a Class Person. Each person
should have name, age and town. You should implement the interface - Comparable and try to override the compareTo
method. When you compare two people, first you should compare their names, after that - their age and last but not at
least - compare their town.


Input
On single lines, you will be given people in format:
{name} {age} {town}
Collect them till you receive "END"
After that, you will receive an integer N - the Nth person in your collection.


Output
On the single output line, you should bring statistics, how many people are equal to him, how many people are not equal
to him and the total people in your collection.
Format:
{number of equal people} {number of not equal people} {total number of people}


Constraints
Names, ages and addresses will be valid.
Input number will be always а valid integer in range [2…100].
If there are no equal people print: "No matches"
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            Person current = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(current);
            input = scanner.nextLine();
        }

        Person mainP = people.get(Integer.parseInt(scanner.nextLine()) - 1);

        int mathching = (int) people.stream().filter(e -> e.compareTo(mainP) == 0).count();

        if (mathching == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d", mathching, people.size() - mathching, people.size()));
        }
    }
}
