package ListyIteratorExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index;

    public ListyIterator(String... args) {
        if (args.length == 0) {
            this.data = new ArrayList<>();
        } else {
            this.data = new ArrayList<>(Arrays.asList(args));
        }
        this.index = 0;
    }

    public boolean Move() {
        if (this.index + 1 < this.data.size()) {
            this.index++;
            return true;
        } else {
            return false;
        }
    }

    public boolean HasNext() {
        return this.index < this.data.size() - 1;
    }

    public void Print() {
        if (this.data.isEmpty()) {
            throw new IndexOutOfBoundsException("Invalid Operation!");
        } else {
            System.out.println(this.data.get(this.index));
        }
    }
}
