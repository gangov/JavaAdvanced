package CollectionExercise;

import java.util.*;

public class ListyIterator implements Iterable<Object> {
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

    @Override
    public Iterator<Object> iterator() {
        return new PrintAll();
    }

    private class PrintAll<T> implements Iterator<String> {
        private int index;

        public PrintAll() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < data.size();
        }

        @Override
        public String next() {
            return data.get(index++);
        }
    }
}
