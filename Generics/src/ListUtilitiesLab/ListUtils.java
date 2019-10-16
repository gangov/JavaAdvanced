package ListUtilitiesLab;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> items) {
        if (items.size() == 0) {
            throw new IllegalArgumentException();
        }

        T max = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            if (max.compareTo(items.get(i)) < 0) {
                max = items.get(i);
            }
        }

        return max;
    }

    public static <T extends Comparable<T>> T getMin(List<T> items) {
        if (items.size() == 0) {
            throw new IllegalArgumentException();
        }

        T min = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            if (min.compareTo(items.get(i)) > 0) {
                min = items.get(i);
            }
        }

        return min;
    }
}
