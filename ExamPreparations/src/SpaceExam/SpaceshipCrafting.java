package SpaceExam;

import java.util.*;

/*
Stephen wants to build a spaceship and start travelling through the galaxy. He has some materials, which upon mixing can
give him the more advanced materials he needs to build the spaceship. You have to help him get the job done.
First, you will be given a sequence of integers, representing chemical liquids. Afterwards, you will be given another
sequence of integers representing physical items.
You need to start from the first liquid and try to mix it with the last physical item. If the sum of their values is
equal to any of the items in the table below – create the item corresponding to the value and remove both the liquid and
the physical item. Otherwise, remove only the liquid and increase the value of the item by 3. You need to stop combining
when you have no more liquids or physical items.
In order to build a spaceship, Stephen needs one of each of the Advanced materials:

Glass - 25
Aluminium - 50
Lithium - 75
Carbon fiber - 100


Input
On the first line, you will receive the integers representing the chemical liquids, separated by a single space.
On the second line, you will receive the integers representing the physical items, separated by a single space.


Output

On the first line of output – print if Stephen succeeded in building the spaceship:
"Wohoo! You succeeded in building the spaceship!"
"Ugh, what a pity! You didn't have enough materials to build the spaceship."

On the second line - print all liquids you have left:
If there are no liquids: "Liquids left: none"
If there are liquids: "Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"

On the third line - print all physical materials you have left:
If there are no items: "Physical items left: none"
If there are items: "Physical items left: {item1}, {item2}, {item3}, (…)"

Then, you need to print all Advanced Materials and the amount you have of them, ordered alphabetically:
"Aluminium: {amount}"
"Carbon fiber: {amount}"
"Glass: {amount}"
"Lithium: {amount}"

Constraints
All of the given numbers will be valid integers in the range [0, 100].
Advanced materials can be crafted more than once.
 */
public class SpaceshipCrafting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] chemichalInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] physicalInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Map<String, Integer> spaceShipParts = new TreeMap<>();
        spaceShipParts.put("Glass", 0);
        spaceShipParts.put("Aluminium", 0);
        spaceShipParts.put("Lithium", 0);
        spaceShipParts.put("Carbon fiber", 0);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> items = new ArrayDeque<>();
        for (int i : chemichalInput) {
            liquids.add(i);
        }

        for (int i : physicalInput) {
            items.push(i);
        }

        while (!liquids.isEmpty() && !items.isEmpty()) {
            int liquid = liquids.remove();
            int item = items.pop();

            if (liquid + item == 25) {
                spaceShipParts.put("Glass", spaceShipParts.get("Glass") + 1);
            } else if (liquid + item == 50) {
                spaceShipParts.put("Aluminium", spaceShipParts.get("Aluminium") + 1);
            } else if (liquid + item == 75) {
                spaceShipParts.put("Lithium", spaceShipParts.get("Lithium") + 1);
            } else if (liquid + item == 100) {
                spaceShipParts.put("Carbon fiber", spaceShipParts.get("Carbon fiber") + 1);
            } else {
                items.addFirst(item + 3);
            }
        }

        //printing general result
        if (spaceShipBuild(spaceShipParts)) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }


        //printing liquids left
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            int end = liquids.size();
            for (int i = 0; i < end; i++) {
                if (i == end - 1) {
                    System.out.println(liquids.poll());
                } else {
                    System.out.print(liquids.poll() + ", ");
                }
            }
        }


        //printing physical items
        if (items.isEmpty()) {
            System.out.println("Physical items left: none");
        } else {
            System.out.print("Physical items left: ");
            int end = items.size();
            for (int i = 0; i < end; i++) {
                if (i == end - 1) {
                    System.out.println(items.poll());
                } else {
                    System.out.print(items.poll() + ", ");
                }
            }
        }


        //printing the items
        spaceShipParts.entrySet().forEach(e -> System.out.println(String.format(
                "%s: %d", e.getKey(), e.getValue()
        )));

    }


    private static boolean spaceShipBuild(Map<String, Integer> spaceShipParts) {
        return spaceShipParts.get("Glass") > 0
                && spaceShipParts.get("Aluminium") > 0
                && spaceShipParts.get("Lithium") > 0
                && spaceShipParts.get("Carbon fiber") > 0;
    }
}
