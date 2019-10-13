package GoogleExercise;

public class Car {
    private String model;
    private String  maxSpeed;

    public String getModel() {
        return model;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public Car(String model, String maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getModel(), this.getMaxSpeed());
    }
}
