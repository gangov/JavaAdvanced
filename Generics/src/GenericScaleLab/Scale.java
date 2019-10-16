package GenericScaleLab;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int comparedResult = this.left.compareTo(right);

        if (comparedResult == 0) {
            return null;
        }

        return comparedResult > 0 ? this.left : this.right;
    }

}
