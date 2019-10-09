package RawDataExercise;

public class Cargo {
    private int cargoWeight;
    private String cargoType;


    //getters and setters
    public int getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }


    //constructor

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }
}
