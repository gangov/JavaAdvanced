package LibraryLab;

import java.util.Iterator;

public class Library<T> implements Iterable<T> {
    private T[] items;

    public Library(T... items) {
        this.items = items;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibraryIterator();
    }


    private class LibraryIterator implements Iterator<T> {

        private int currentIndex;

        LibraryIterator() {
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentIndex + 1 <= items.length;
        }

        @Override
        public T next() {
            return items[this.currentIndex++];
        }
    }
}
