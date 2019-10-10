package CarSalesmanExercise;

public class Engine {
    //String model, int power, intO displacement and StringO efficiency
    private String model;
    private int power;
    private String displacement;
    private String efficiency;


    //getters
    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    //constructor
    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }



    //methods
//    public void engineInfo() {
//        if (this.displacement == -1) {
//            System.out.println(String.format("%s:%n" +
//                    "Power: %d%n" +
//                    "Displacement: %s%n" +
//                    "Efficiency: %s%n", this.model, this.power, "n/a", this.efficiency));
//        } else {
//            System.out.println(String.format("%s:%n" +
//                    "Power: %d%n" +
//                    "Displacement: %d%n" +
//                    "Efficiency: %s%n", this.model, this.power, this.displacement, this.efficiency));
//        }
//    }
}
