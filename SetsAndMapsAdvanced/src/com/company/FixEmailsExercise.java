package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
You are given a sequence of strings, each on a new line, unitll you receive “stop” command. First string is a name of
a person. On the second line you receive his email. Your task is to collect their names and emails, and remove emails
whose domain ends with "us", "uk" or “com” (case insensitive). Print:
{name} – > {email}
 */
public class FixEmailsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayList<String> namesFollowedBy = new ArrayList<>();
        int count = 0;

        while (!input.equals("stop")) {
            if (count % 2 == 0) {
                namesFollowedBy.add(input);
            } else {
                namesFollowedBy.add(input);
            }

            count++;
            input = scanner.nextLine();
        }

        LinkedHashMap<String, String> contactInformation = new LinkedHashMap<>();

        for (int i = 0; i < namesFollowedBy.size(); i += 2) {
            String name = namesFollowedBy.get(i);
            String email = namesFollowedBy.get(i + 1);

            contactInformation.putIfAbsent(name, email);
        }

        for (Map.Entry<String, String> nameAndEmail : contactInformation.entrySet()) {
            String name = nameAndEmail.getKey();
            String email = nameAndEmail.getValue();

            if (!email.contains(".us") && !email.contains("uk") && !email.contains(".com")) {
                System.out.printf("%s -> %s%n", name, email);
            }
        }
    }
}
