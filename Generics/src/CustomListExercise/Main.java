package CustomListExercise;

import java.util.Scanner;

/*
Create a generic data structure that can store any type that can be compared. Implement functions:
void add(T element)
T remove(int index)
boolean contains(T element)
void swap(int index, int index)
int countGreaterThan(T element)
T getMax()
T getMin()

Create a command interpreter that reads commands and modifies the custom list that you have created. Implement the
commands:
Add <element> - Adds the given element to the end of the list
Remove <index> - Removes the element at the given index
Contains <element> - Prints if the list contains the given element (true or false)
Swap <index> <index> - Swaps the elements at the given indexes
Greater <element> - Counts the elements that are greater than the given element and prints their count
Max - Prints the maximum element in the list
Min - Prints the minimum element in the list
Print - Prints all elements in the list, each on a separate line
END - stops the reading of commands
Note: For the Judge tests, use String as T.
 */
public class Main {
    public static void main(String[] args) {Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        CustomList<String> theList = new CustomList<>();

        while (!command.equals("END")) {
            String[] input = command.split("\\s+");

            switch (input[0]) {
                case "Add":
                    theList.add(input[1]);
                    break;
                case "Remove":
                    theList.remove(Integer.parseInt(input[1]));
                    break;
                case "Contains":
                    System.out.println(theList.contains(input[1]));
                    break;
                case "Swap":
                    theList.swap(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    break;
                case "Greater":
                    System.out.println(theList.thatAreGreater(input[1]));
                    break;
                case "Max":
                    System.out.println(theList.getMax());
                    break;
                case "Min":
                    System.out.println(theList.getMin());
                    break;
                case "Print":
                    for (String s : theList) {
                        System.out.println(s);
                    }
                case "Sort":
                    theList.sorted();
                    break;
            }

            command = scanner.nextLine();
        }

    }
}
