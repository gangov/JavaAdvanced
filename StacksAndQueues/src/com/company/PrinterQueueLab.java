package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
The printer queue is a simple way to control the order of files sent to a printer device. We know that a single printer
can be shared between multiple devices. So to preserve the order of the files sent, we can use queue. Write down a
program which takes filenames until "print" command is received. Then as output print the filenames in the order of
printing. Some of the tasks may be canceled if you receive "cancel" you have to remove the first file to be printed.
If there is no current file to be printed print "Printer is on standby".
 */
public class PrinterQueueLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> printing = new ArrayDeque<>();

        while (!command.equals("print")) {
            if (command.equals("cancel")) {
                if (printing.size() < 1) {
                    System.out.println("Printer is on standby");
                } else {
                    String name = printing.poll();
                    System.out.println("Canceled " + name);
                }
            } else {
                printing.offer(command);
            }

            command = scanner.nextLine();
        }

        for (String s : printing) {
            System.out.println(s);
        }
    }
}
