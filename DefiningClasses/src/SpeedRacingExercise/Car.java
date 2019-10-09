package SpeedRacingExercise;

public class Car {
    private String model;
    private double tank;
    private double fuelCost;
    private int distanceTravelled;



    //GETTERS AND SETTERS
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getTank() {
        return tank;
    }

    public void setTank(double tank) {
        this.tank = tank;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }



    //CONSTRUCTOR
    public Car(String mode, double tank, double fuelCost) {
        this.model = mode;
        this.tank = tank;
        this.fuelCost = fuelCost;
        this.distanceTravelled = 0;
    }



    //methods
    public boolean checkIfCanTravel(int neededDistance) {
        return !(this.fuelCost * neededDistance > tank);
    }

    public Car updateCar(int neededDistance) {
        this.tank -= this.fuelCost * neededDistance;
        this.distanceTravelled += neededDistance;
        return this;
    }


    //METHODS
}
