package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

/*
You will be given an integer N representing the number of elements to push onto the stack, an integer S representing
the number of elements to pop from the stack and finally an integer X, an element that you should check whether is
present in the stack. If it is, print true on the console. If it’s not, print the smallest element currently present
in the stack.
 */
public class BasicStackOperationsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");

        int elementsNum = Integer.parseInt(nums[0]);
        int removeElemts = Integer.parseInt(nums[1]);
        int findElemts = Integer.parseInt(nums[2]);

        ArrayDeque<Integer> entryNumbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).limit(elementsNum).forEach(entryNumbers::push);

        for (int i = 0; i < removeElemts; i++) {
            entryNumbers.pop();
        }

        if (entryNumbers.contains(findElemts)) {
            System.out.println("true");
        } else {
            int minNum = MAX_VALUE;

            if (entryNumbers.isEmpty()) {
                minNum = 0;
            }

            for (Integer entryNumber : entryNumbers) {
                if (minNum > entryNumber) {
                    minNum = entryNumber;
                }
            }
            System.out.println(minNum);
        }

    }
}
