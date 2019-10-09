package SpeedRacingExercise;

import java.util.*;

/*
Your task is to implement a program that keeps track of cars and their fuel and supports methods for moving the cars.
Define a class Car that keeps track of a car information Model, fuel amount, fuel cost for 1 kilometer and distance
traveled. A Car Model is unique - there will never be 2 cars with the same model.
On the first line of the input you will receive a number N - the number of cars you need to track, on each of the next N
lines you will receive information for a car in the following format "<Model> <FuelAmount> <FuelCostFor1km>", all cars
start at 0 kilometers traveled.
After the N lines until the command "End" is received, you will receive commands in the following format "Drive
<CarModel>  <amountOfKm>", implement a method in the Car class to calculate whether a car can move that distance or not.
If it can, the car fuel amount should be reduced by the amount of used fuel and its distance traveled should be
increased by the amount of kilometers traveled, otherwise the car should not move (Its fuel amount and distance traveled
should stay the same) and you should print on the console "Insufficient fuel for the drive". After the "End" command is
received, print each car in order of appearing in input and its current fuel amount and distance traveled in the format
"<Model> <fuelAmount>  <distanceTraveled>", where the fuel amount should be printed to two decimal places after the
separator.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Car[]> garage = new LinkedHashMap<>();

        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String make = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCost = Double.parseDouble(input[2]);
            Car car = new Car(make, fuelAmount, fuelCost);
            garage.putIfAbsent(car.getModel(), new Car[1]);
            garage.get(car.getModel())[0] = car;
        }

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("End")) {
            String model = command[1];
            int distanceToTravel = Integer.parseInt(command[2]);
            Car currentCar = garage.get(model)[0];

            if (currentCar.checkIfCanTravel(distanceToTravel)) {
                currentCar.updateCar(distanceToTravel);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine().split("\\s+");
        }

        for (Map.Entry<String, Car[]> modelAndStuff : garage.entrySet()) {
            String model = modelAndStuff.getKey();

            System.out.println(String.format("%s %.2f %s", model, modelAndStuff.getValue()[0].getTank()
            , modelAndStuff.getValue()[0].getDistanceTravelled()));
        }
    }
}
