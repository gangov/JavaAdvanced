package com.company;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Scanner;

/*
Somewhere in the future, there is a robotics factory. The current project is assembly line robots.
Each robot has a processing time, the time it needs to process a product. When a robot is free it should take a product
 for processing and log his name, product and processing start time.
Each robot processes a product coming from the assembly line. A product is coming from the line each second
(so the first product should appear at [start time + 1 second]). If a product passes the line and there is not a free
robot to take it, it should be queued at the end of the line again.
The robots are standing on the line in the order of their appearance.
 */
public class RoboticsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] roboData = scanner.nextLine().split(";");

        String[] robots = new String[roboData.length];
        int[] workingTime = new int[roboData.length];
        int[] processTime = new int[roboData.length];

        for (int i = 0; i < roboData.length; i++) {
            robots[i] = roboData[i].split("-")[0];
            workingTime[i] = Integer.parseInt(roboData[i].split("-")[1]);
        }

        String[] timeData = scanner.nextLine().split(":");

        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTime = hours * 3600 + minutes * 60 + seconds;

        int time = 0;

        ArrayDeque<String> products = new ArrayDeque<>();

        String currentProduct = scanner.nextLine();

        while (!currentProduct.equals("End")) {
            products.offer(currentProduct);
            currentProduct = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            time++;
            String product = products.pollFirst();

            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] == 0 && !isAssigned) {
                    processTime[i] = workingTime[i];
                    printTask(robots[i], startTime + time, product);
                    isAssigned = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }

            if (!isAssigned) {
                products.offer(product);
            }
        }
    }

    private static void printTask(String robot, int time, String product) {
        int hours = (time / 3600) % 24;
        int minutes = time % 3600 / 60;
        int seconds = time % 60;

        DecimalFormat format = new DecimalFormat("00");

        System.out.println(String.format("%s - %s [%s:%s:%s]", robot, product,
                format.format(hours), format.format(minutes), format.format(seconds)));
    }
}
