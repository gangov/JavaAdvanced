package GenericBoxExercise;

public class Box<T> {

    private T input;

    public Box(T input) {
        this.input = input;
    }


    public String toString(T input) {
        return String.format("%s: %s", this.input.getClass().getName(), this.input);
    }
}
