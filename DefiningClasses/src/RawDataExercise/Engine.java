package RawDataExercise;

public class Engine {
    private int enginePower;
    private int engineSpeed;

    //getters and setters
    public int getEnginePower() {
        return enginePower;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }


    //constructor

    public Engine(int enginePower, int engineSpeed) {
        this.enginePower = enginePower;
        this.engineSpeed = engineSpeed;
    }
}
