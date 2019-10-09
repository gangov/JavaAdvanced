package CarConstructorsLab;

import java.util.Scanner;

/*
Make proper constructors for the Car class so you can create car objects with different type of input information.
If you miss information about field of type String set the value to "unknown", and for integer field set -1.
First declare constructor which takes only the car make as parameter.

Read information about car the same way as the previous task, however this time use constructors to create the objects,
not creating object with the default constructor. You should be able to handle different types of input, the format will
be the same as the previous task, but this time some of the data may be missing. For an example you can get only the car
make – which means you have to set the car model to "unknown" and the Horse Power value to -1. There will be lines with
complete car data, declare constructor which sets all the fields.
You have to add the car objects to a collection of your chose and print the data as in the previous task. The input will
always have one or three elements on each line.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 1) {
                String make = input[0];
                Car theCar = new Car(make);
                theCar.carInfo();
            } else {
                String make = input[0];
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);

                Car theCar = new Car(make, model, horsePower);
                theCar.carInfo();
            }

        }
    }
}
