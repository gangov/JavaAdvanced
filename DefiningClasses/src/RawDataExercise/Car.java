package RawDataExercise;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tires> tires;


    //getters and setters
    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tires> getTires() {
        return tires;
    }


    //constructor

    public Car(String model, int enginePower, int engineSpeed, int cargoWeight, String cargoType, List<Tires> tires) {
        this.model = model;
        engine = new Engine(enginePower, engineSpeed);
        cargo = new Cargo(cargoWeight, cargoType);
        this.tires = tires;
    }
}
