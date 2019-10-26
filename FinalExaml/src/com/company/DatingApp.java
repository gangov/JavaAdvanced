package com.company;
/*
First you will be given a sequence of integers representing males. Afterwards you will be given another sequence of
integers representing females.
You have to start from the first female and try to match it with the last male. If their values are equal, you have to
match them and remove both of them. Otherwise you should remove only the female and decrease the value of the male by 2.
If someone’s value is equal to or below 0, you should remove him/her from the records before trying to match him/her
with anybody. Special case - if someone’s value divisible by 25 without remainder, you should remove him/her and the
next person of the same gender. You need to stop matching people when you have no more females or males.


Input
On the first line of input you will receive the integers, representing the males, separated by a single space.
On the second line of input you will receive the integers, representing the females, separated by a single space.


Output
On the first line of output - print the number of successful matches:
"Matches: {matchesCount}"
On the second line - print all males left:
If there are no males: "Males left: none"
If there are males: "Males left: {male1}, {male2}, {male3}, (…)"
On the third line - print all females left:
If there are no females: "Females left: none"
If there are females: "Females left: {female1}, {female2}, {female3}, (…)"


Constraints
All of the given numbers will be valid integers in the range [-100, 100].
 */
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] malesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] femalesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> males = new ArrayDeque<>(); // Stack
        for (int male : malesInput) {
            males.push(male);
        }

        ArrayDeque<Integer> females = new ArrayDeque<>(); // Queue
        for (int female : femalesInput) {
            females.offer(female);
        }

        int matchedCouples = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int currentFemale = females.poll();
            int currentMale = males.pop();

            if (currentFemale <= 0 || currentMale <= 0) {
                if (currentFemale <= 0) {
                    males.push(currentMale);
                }
                if (currentMale <= 0) {
                    females.addFirst(currentFemale);
                }

                continue;
            }

            if (currentFemale % 25 == 0 || currentMale % 25 == 0) {
                if (currentFemale % 25 == 0) {
                    females.poll();
                    males.push(currentMale);
                }
                if (currentMale % 25 == 0) {
                    males.pop();
                    females.addFirst(currentFemale);
                }

                continue;
            }

            if (currentFemale == currentMale) {
                matchedCouples++;
            } else {
                currentMale -= 2;
                males.push(currentMale);
            }
        }

        System.out.println("Matches: " + matchedCouples);

        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            int countM = 0;
            int end = males.size() - 1;
            System.out.print("Males left: ");
            for (Integer male : males) {
                if (countM == end) {
                    System.out.print(male + System.lineSeparator());
                } else {
                    System.out.print(male + ", ");
                }
                countM++;
            }
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            int countF = 0;
            int end = females.size() - 1;
            System.out.print("Females left: ");
            for (Integer female : females) {
                if (countF == end) {
                    System.out.print(female + System.lineSeparator());
                } else {
                    System.out.print(female + ", ");
                }
                countF++;
            }
        }
    }
}
