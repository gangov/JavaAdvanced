package GenericSwapMethodStringsExercise;

import java.util.*;

/*
Create a generic method that receives a list containing any type of data and swaps the elements at two given indexes.
As in the previous problems, read n number of boxes of type String and add them to the list. On the next line, however,
you will receive a swap command consisting of two indexes. Use the method you've created to swap the elements that
correspond to the given indexes and print each element in the list.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Box> total = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> item = new Box<>(input);
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
