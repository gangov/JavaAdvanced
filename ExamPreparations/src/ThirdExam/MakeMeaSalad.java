package ThirdExam;

import java.util.*;

/*
Write a program that helps you prepare vegetable salads, which must be with a definite amount of calories. You will
receive two lines. The first one will be the vegetables. The second one, the calorie values of the salads. Both will be
separated by a single space. They will come in the following format:
"{vegetable1} {vegetable2}… {vegetablen}"
"{calories1} {calories2}… {caloriesn}"
Here is a table with the exact names of the vegetables and their calories:
    Vegetables : Calories
    tomato     :    80
    carrot     :    136
    lettuce    :    109
    potato     :    215

Start making the salads in the following way: take the last received calories and start adding vegetables from the first
received vegetable. Each time you take a vegetable, you must reduce the amount of calories for the given salad with its
calorie value and remove it from the collection. A salad is considered ready, when its calorie value reaches 0. When the
salad is ready, remove it from the collection. If the calories of the current vegetable exceed the amount of needed
calories for the salad, finish the salad and throw what is left of the vegetable. When you run out of either salads to
make, or vegetables, print the salads you made (their calorie value) on a single line, separated by space, beginning
with the first salad you made in the following format:
"{salad1} {salad2}… {saladn}"
At last, print either the vegetables that are left, or the calories of the salads you couldn't prepare, depending on the
case – if you have vegetables left, print them, if you have salads left, print them on a single line, separated by
space.


Input
On the first line, you will receive the vegetables – strings separated by a single space.
On the second line, you will receive the salads' calories – integers, separated by a single space.
Input will always be valid.


Output
Print the finished salads' calories from the first made one to the last one in the format described above
 */
public class MakeMeaSalad {
    private static int requiredCalories = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputVegies = scanner.nextLine().split("\\s+");
        int[] inputCalories = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<String> vegetables = new ArrayDeque<>();
        ArrayDeque<Integer> calories = new ArrayDeque<>();
        LinkedHashMap<Integer, Integer> cal = new LinkedHashMap<>();
        List<Integer> readySalads = new ArrayList<>();
        for (String inputVegy : inputVegies) {
            vegetables.offer(inputVegy);
        }

        for (int inputCalory : inputCalories) {
            calories.push(inputCalory);
            cal.put(inputCalory, inputCalory);
        }



        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            String element = vegetables.remove();
            int valueOfVegy = 0;

            switch (element) {
                case "tomato":
                    valueOfVegy = 80;
                    break;
                case "carrot":
                    valueOfVegy = 136;
                    break;
                case "lettuce":
                    valueOfVegy = 109;
                    break;
                case "potato":
                    valueOfVegy = 215;
                    break;
            }

            int salad = getLast(cal);

            if (cal.size() < 1) {
                break;
            }
            if (cal.get(salad) - valueOfVegy > 0) {
                cal.put(salad, cal.get(salad) - valueOfVegy);
                if (vegetables.isEmpty()) {
                    readySalads.add(salad);
                    cal.remove(salad);
                    calories.pop();
                }
            } else {
                readySalads.add(salad);
                cal.remove(salad);
                calories.pop();
            }
        }


        for (Integer readySalad : readySalads) {
            System.out.print(readySalad + " ");
        }

        System.out.println();

        if (!vegetables.isEmpty()) {
            for (String vegetable : vegetables) {
                System.out.print(vegetable + " ");
            }
        }

        if (!calories.isEmpty()) {
            for (Integer calory : calories) {
                System.out.print(calory + " ");
            }
        }
    }

    private static int getLast(LinkedHashMap<Integer, Integer> cal) {
        int salad = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : cal.entrySet()) {
            salad = integerIntegerEntry.getKey();
        }
        return salad;
    }
}
