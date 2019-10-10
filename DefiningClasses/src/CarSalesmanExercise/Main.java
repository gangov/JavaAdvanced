package CarSalesmanExercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/*
Define two classes Car and Engine. A Car has a model, engine, weight and color. An Engine has model, power, displacement
and efficiency. A Cars weight and color and its Engine’s displacements and efficiency are optional.
On the first line, you will read a number N which will specify how many lines of engines you will receive, on each of
the next N lines you will receive information about an Engine in the following format "<Model> <Power> <Displacement>
<Efficiency>". After the lines with engines, on the next line you will receive a number M – specifying the number of
Cars that will follow, on each of the next M lines the information about a Car will follow in the following format
"<Model> <Engine> <Weight> <Color>", where the engine in the format will be the model of an existing Engine. When
creating the object for a Car, you should keep a reference to the real engine in it, instead of just the engines model,
note that the optional properties might be missing from the formats.
Your task is to print each car (in the order you received them) and its information in the format defined bellow. If any
of the optional fields has not been given print "n/a" in its place instead of:
<CarModel>: <EngineModel>: Power: <EnginePower> Displacement: <EngineDisplacement> Efficiency: <EngineEfficiency> 
Weight: <CarWeight> Color: <CarColor>

Optional
Override the classes ToString() methods to have a reusable way of displaying the objects.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countEngines = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Engine> allEngines = new LinkedHashMap<>();

        for (int i = 0; i < countEngines; i++) {
            String[] engineFormat = scanner.nextLine().split("\\s+");
            String model = engineFormat[0];
            int power = Integer.parseInt(engineFormat[1]);

            Engine engine = new Engine(model, power);
            if (engineFormat.length > 2) {
                if (Character.isDigit(engineFormat[engineFormat.length - 1].charAt(0))) {
                    String displacement = engineFormat[2];
                    engine.setDisplacement(displacement);
                } else {
                    String efficiency = engineFormat[2];
                    engine.setEfficiency(efficiency);
                }
            }
            if (engineFormat.length > 3) {
                String displacement = engineFormat[2];
                engine.setDisplacement(displacement);
                String efficiency = engineFormat[3];
                engine.setEfficiency(efficiency);
            }

            allEngines.put(model, engine);
        }

        int countCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < countCars; i++) {
            String[] carFormat = scanner.nextLine().split("\\s+");
            String model = carFormat[0];
            String engine = carFormat[1];
            Car car = new Car(model, allEngines.get(engine));

            if (carFormat.length > 2) {
                if (Character.isDigit(carFormat[carFormat.length - 1].charAt(0))) {
                    String weight = carFormat[2];
                    car.setWeight(weight);
                } else {
                    String color = carFormat[2];
                    car.setColor(color);
                }
            }
            if (carFormat.length > 3) {
                String weight = carFormat[2];
                car.setWeight(weight);
                String color = carFormat[3];
                car.setColor(color);
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }

    private static int findEngineIndex(String engine, List<Engine> allEngines) {
        int point = 0;
        for (Engine allEngine : allEngines) {
            if (allEngine.getModel().equals(engine)) {
                return point;
            }
            point++;
        }
        return point;
    }
}
