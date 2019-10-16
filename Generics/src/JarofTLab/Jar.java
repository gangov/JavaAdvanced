package JarofTLab;

import java.util.ArrayDeque;

public class Jar<T> {

    private ArrayDeque<T> jarDeque;

    public Jar() {
        this.jarDeque = new ArrayDeque<>();
    }

    public void add(T element) {
        this.jarDeque.push(element);
    }

     public T remove() {
         return this.jarDeque.pop();
    }
}
