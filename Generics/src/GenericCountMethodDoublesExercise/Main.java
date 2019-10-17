package GenericCountMethodDoublesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Use the description of the previous problem but now, test your list of generic boxes with Doubles.

Previous exercise:
Create a method that receives as argument a list of any type that can be compared and an element of the given type. The
method should return the count of elements that are greater than the value of the given element. Modify your Box class
to support comparing by value of the data stored.
On the first line you will receive n - the number of elements to add to the list. On the next n lines, you will receive
the actual elements. On the last line you will get the value of the element to which you need to compare every element
in the list.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Double> all = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(scanner.nextLine());

            all.add(input);
        }

        double compareBy = Double.parseDouble(scanner.nextLine());

        getCount(all, compareBy);
    }

    private static <T extends Comparable> void getCount(List<Double> all, double compareBy) {
        int count = 0;

        for (Double aDouble : all) {
            if (aDouble.compareTo(compareBy) > 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
