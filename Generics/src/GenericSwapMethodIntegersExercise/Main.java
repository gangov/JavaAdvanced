package GenericSwapMethodIntegersExercise;

import java.util.*;

/*
Use the description of the previous problem but now, test your list of generic boxes with Integers.

Previous problem:
Create a generic method that receives a list containing any type of data and swaps the elements at two given indexes.
As in the previous problems, read n number of boxes of type String and add them to the list. On the next line, however,
you will receive a swap command consisting of two indexes. Use the method you've created to swap the elements that
correspond to the given indexes and print each element in the list.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<GenericSwapMethodIntegersExercise.Box> total = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            GenericSwapMethodIntegersExercise.Box<Integer> item = new GenericSwapMethodIntegersExercise.Box<>(input);
            total.add(item);
        }

        int[] replace = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Collections.swap(total, replace[0], replace[1]);

        for (Box box : total) {
            System.out.println(box.toString());
        }
    }
}
