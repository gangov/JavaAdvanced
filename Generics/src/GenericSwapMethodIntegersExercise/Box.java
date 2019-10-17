package GenericSwapMethodIntegersExercise;

public class Box<T> {
    private T entry;

    public Box(T entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return this.entry.getClass().getName() + ": " + this.entry;
    }
}
