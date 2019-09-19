package com.company;
/*Write a program which takes 2 types of browser instructions:
Normal navigation: a URL is set, given by a string
The string "back" that sets the current URL to the last set URL
After each instruction the program should print the current URL. If the back instruction can’t be executed, print
  "no previous URLs". The input ends with "Home" command, then simply you have to stop the program.
*/
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> urls = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (urls.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    urls.pop();
                    String backURL = urls.pop();
                    System.out.println(backURL);
                    urls.push(backURL);
                }
            } else {
                urls.push(input);
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }
}
