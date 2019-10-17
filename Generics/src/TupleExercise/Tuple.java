package TupleExercise;

public class Tuple<First, Second> {
    private First elementFirst;
    private Second elementSecond;

    public Tuple(First elementFirst, Second elementSecond) {
        this.elementFirst = elementFirst;
        this.elementSecond = elementSecond;
    }

    @Override
    public String toString() {
        return this.elementFirst + " -> " + this.elementSecond;
    }
}
