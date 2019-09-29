package com.company;

import java.util.HashMap;
import java.util.Scanner;

/*
Write a program that receives some info from the console about people and their phone numbers.
You are free to choose the manner in which the data is entered; each entry should have just one name and one number
(both of them strings). If you receive a name that already exists in the phonebook, simply update its number.
After filling this simple phonebook, upon receiving the command "search", your program should be able to perform a
search of a contact by name and print her details in format "{name} -> {number}". In case the contact isn't found,
print "Contact {name} does not exist." Examples:
 */
public class PhonebookExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phoneBook = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            if (phoneBook.containsKey(name)) {
                phoneBook.put(name, phoneNumber);
            }
            phoneBook.putIfAbsent(name, phoneNumber);

            input = scanner.nextLine();
        }

        String searchName = scanner.nextLine();

        while (!searchName.equals("stop")) {
            if (phoneBook.containsKey(searchName)) {
                System.out.printf("%s -> %s%n", searchName, phoneBook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }

            searchName = scanner.nextLine();
        }
    }
}
