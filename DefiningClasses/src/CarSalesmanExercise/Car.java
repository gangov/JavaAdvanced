package CarSalesmanExercise;

public class Car {
    //model, engine, weight and color
    private String model;
    private Engine engine;
    private String weight;
    private String color;


    //getters
    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //constructor
    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }


    //methods
    public String toString() {
        return String.format("%s:%n" +
                        "%s:%n" +
                        "Power: %d%n" +
                        "Displacement: %s%n" +
                        "Efficiency: %s%n" +
                        "Weight: %s%n" +
                        "Color: %s", this.model, this.getEngine().getModel(), this.getEngine().getPower(),
                this.getEngine().getDisplacement(), this.getEngine().getEfficiency(),
                this.getWeight(), this.getColor());


    }
}
