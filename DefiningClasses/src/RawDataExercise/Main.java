package RawDataExercise;

import java.util.*;
import java.util.stream.Collectors;

/*
You are the owner of a courier company and you want to make a system for tracking your cars and their cargo. Define a
class Car that holds information about model, engine, cargo and a collection of exactly 4 tires. The engine, cargo and
tire should be separate classes, create a constructor that receives all information about the Car and creates and
initializes its inner components (engine, cargo and tires).
On the first line of the input you will receive a number N - the number of cars you have, on each of the next N lines
you will receive information about a car in the format "<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType>
<Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>" where the
speed, power, weight and tire age are integers, tire pressure is a double.
After the N lines you will receive a single line with one of 2 commands "fragile" or "flamable" , if the command is
"fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1, if the command is "flamable"
print all cars whose Cargo Type is "flamable" and have Engine Power > 250. The cars should be printed in order of
appearing in the input.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Car[] vehicles = new Car[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            String[] tyres = Arrays.copyOfRange(input, 5, input.length);
            int[] tyreByAge = fillTyresArraysA(tyres);
            double[] tyreByPressure = fillTyresArraysP(tyres);
            List<Tires> allTyres = new ArrayList<>();
            Tires tyre = new Tires();
            for (int j = 0; j < 4; j++) {
                tyre.setAge(tyreByAge[j]);
                tyre.setPressure(tyreByPressure[j]);

                allTyres.add(tyre);
            }


            Car car = new Car(model, power, speed, weight, type, allTyres);
            vehicles[i] = car;
        }

        String filter = scanner.nextLine();

        List<String> names = new ArrayList<>();
        if (filter.equals("fragile")) {
            Arrays.stream(vehicles).forEach(v -> {
                List<Tires> tires = v.getTires().stream().filter(Tires::isFragile).collect(Collectors.toList());
                if (!tires.isEmpty()) {
                    System.out.println(v.getModel());
                }
            });
        }

        for (String name : names) {
            System.out.println(name);
        }
        if (filter.equals("flamable")) {
            Arrays.stream(vehicles).forEach(v -> {
                int power = v.getEngine().getEnginePower();
                if (power > 250) {
                    System.out.println(v.getModel());
                }
            });
        }
    }

    private static double[] fillTyresArraysP(String[] tyres) {
        double[] array = new double[4];
        int pressureNum = 0;
        for (int j = 0; j < tyres.length; j++) {
            if (j % 2 == 0) {
                array[pressureNum] = Double.parseDouble(tyres[j]);
                pressureNum++;
            }
        }
        return array;
    }

    private static int[] fillTyresArraysA(String[] tyres) {
        int[] array = new int[4];
        int ageNum = 0;
        for (int j = 0; j < tyres.length; j++) {
            if (j % 2 != 0) {
                array[ageNum] = Integer.parseInt(tyres[j]);
                ageNum++;
            }
        }

        return array;
    }
}
