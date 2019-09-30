package com.company;
/*
Write program that:
Records car number for every car that enter in parking lot
Removes car number when the car go out
Input
The input will be string in format [direction, carNumber]
The input ends with string "END"
Output
Print the output with all car numbers which are in parking lot

 */
import java.util.*;

public class ParkingLotLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashSet<String> parkingLot = new HashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String plate = tokens[1];

            if (command.equals("IN")) {
                parkingLot.add(plate);
            } else {
                parkingLot.remove(plate);
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
//            for (String s : parkingLot) {
////                System.out.println(s);
////            }
            parkingLot.forEach(plate -> System.out.println(plate + " "));
        }
    }
}
