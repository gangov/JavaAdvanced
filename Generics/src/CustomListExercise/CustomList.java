package CustomListExercise;

import java.util.*;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public void remove(int index) {
        this.data.remove(index);
    }

    public int size() {
        return this.data.size();
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int first, int second) {
        Collections.swap(this.data, first, second);
    }

    public int thatAreGreater(T element) {
        return (int) this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Collections.max(this.data);
    }

    public T getMin() {
        return Collections.min(this.data);
    }

    public void sorted() {
        Collections.sort(this.data);
    }

    public void forEach() {
        for (T datum : data) {
            System.out.println(datum);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.data.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
