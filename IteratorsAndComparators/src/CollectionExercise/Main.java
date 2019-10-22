package CollectionExercise;

import java.util.Arrays;
import java.util.Scanner;

/*
Using the ListyIterator from the last problem, extend it by implementing the "Iterable" interface, implement all methods
desired by the interface manually. Add a new method to the class PrintAll(), the method should foreach the collection
and print all elements on a single line separated by a space.


Input

Input will come from the console as lines of commands. The first line will always be the Create command in the input.
The last command received will always be the END command.


Output
For every command from the input (with the exception of the END and Create commands) print the result of that command on
the console, each on a new line. In case of Move or HasNext commands print the returned value of the method, in case of
a Print command you don’t have to do anything additional as the method itself should already print on the console. In
case of a PrintAll command you should print all elements on a single line separated by spaces. Your program should catch
any exceptions thrown because of validations and print their messages instead.


Constraints
Do not use the built in iterators!
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
                case "PrintAll":
                    entryData.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }

            tokens = scanner.nextLine().split("\\s+");
        }
    }
}
