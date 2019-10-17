package ThreeupleExercise;

public class Threeuple<F, S, T> {
    private F first;
    private S second;
    private T third;

    public Threeuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return this.first + " -> " + this.second + " -> " + this.third;
    }
}
