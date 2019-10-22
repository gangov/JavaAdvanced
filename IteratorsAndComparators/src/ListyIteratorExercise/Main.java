package ListyIteratorExercise;

import java.util.Arrays;
import java.util.Scanner;

/*
Create a class "ListyIterator", it should receive the collection of Strings which it will iterate, through its
constructor. You should store the elements in a List. The class should have three main functions:
Move - should move an internal index position to the next index in the list, the method should return true if it
successfully moved and false if there is no next index.
HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
Print - should print the element at the current internal index, calling Print on a collection without elements should
throw an appropriate exception with the message "Invalid Operation!".


Input
Input will come from the console as lines of commands. The first line will always be Create command in the input. The
last command received will always be END command.


Output
For every command from the input (with the exception of the END and Create commands) print the result of that command on
the console, each on a new line. In case of Move or HasNext commands print the returned value of the method, in case of
a Print command you don’t have to do anything additional as the method itself should already print on the console. Your
program should catch any exceptions thrown because of validations (calling Print on an empty collection) and print their
messages instead.


Constraints
There will always be only one Create command and it will always be the first command passed.
The number of commands received will be between [1…100].
The last command will always be the END command.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        String[] initial = Arrays.copyOfRange(tokens, 1, tokens.length);

        ListyIterator entryData = new ListyIterator(initial);

        while (!tokens[0].equals("END")) {
            switch (tokens[0]) {
                case "Move":
                    System.out.println(entryData.Move());
                    break;
                case "HasNext":
                    System.out.println(entryData.HasNext());
                    break;
                case "Print":
                    try {
                        entryData.Print();
                    } catch (Exception e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
            }

            tokens = scanner.nextLine().split("\\s+");
        }
    }
}
