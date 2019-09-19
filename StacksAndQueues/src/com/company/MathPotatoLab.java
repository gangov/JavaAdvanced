package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
Rework the previous problem so that a child is removed only on a composite (not prime) cycle  (cycles start from 1)
If a cycle is prime, just print the child's name.
As before, print the name of the child that is left last.
 */
public class MathPotatoLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        ArrayDeque<String> players = new ArrayDeque<>();
        for (String name : names) {
            players.offer(name);
        }

        int count = scanner.nextInt();
        int cycle = 1;

        while (players.size() > 1) {
            for (int i = 1; i < count; i++) {
                String name = players.poll();
                players.offer(name);
            }

            String name = players.peek();
            if (!countIsPrime(cycle)) {
                System.out.println("Removed " + name);
                players.remove(name);
            } else {
                System.out.println("Prime " + name);
            }

            cycle++;
        }

        System.out.println("Last is " + players.peek());
    }

    public static boolean countIsPrime(int num) {
        if (num == 1) {
            return false;
        }
        for(int i = 2; i < num; ++i) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
