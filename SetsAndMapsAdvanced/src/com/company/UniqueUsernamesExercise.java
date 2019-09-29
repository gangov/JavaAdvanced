package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/*
Write a simple program that reads from the console a sequence of usernames and keeps a collection with only the unique
ones. Print the collection on the console in order of insertion:
 */
public class UniqueUsernamesExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {
            String user = scanner.nextLine();
            usernames.add(user);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
