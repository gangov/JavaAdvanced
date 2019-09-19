package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
Extend "Browser History" with a "forward" instruction which visits URLs that were navigated away from by "back"
Each forward instruction visits the next most-recent such URL. If a normal navigation happens, all potential forward
URLs are removed until a new back instruction is given If the forward instruction can’t be executed, print
 "no next URLs".
 */
public class BrowserHistoryUpgradeLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (back.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forward.addFirst(back.pop());
                    String backURL = back.pop();
                    System.out.println(backURL);
                    back.push(backURL);
                }
            } else if (command.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.poll());
                }
            } else {
                back.push(command);
                System.out.println(command);
                forward.clear();
            }
            command = scanner.nextLine();
        }

    }
}
