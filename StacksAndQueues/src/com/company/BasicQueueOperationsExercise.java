package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/*
You will be given an integer N representing the number of elements to enqueue (add), an integer S representing the
number of elements to dequeue (remove/poll) from the queue and finally an integer X, an element that you should check
whether is present in the queue. If it is print true on the console, if it’s not print the smallest element currently
present in the queue.
 */
public class BasicQueueOperationsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int totals = commands[0];
        int remove = commands[1];
        int find = commands[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(numbers::offer);

        for (int i = 0; i < remove; i++) {
            numbers.poll();
        }

        if (numbers.contains(find)) {
            System.out.println("true");
        } else {
            int minNum = Integer.MAX_VALUE;

            if (numbers.isEmpty()) {
                minNum = 0;
            }
            for (Integer number : numbers) {

                if (number < minNum) {
                    minNum = number;
                }
            }

            if (numbers.size() == 0) {
                System.out.println(0);
            } else {
                System.out.println(minNum);
            }

        }
    }
}
