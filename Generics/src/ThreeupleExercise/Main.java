package ThreeupleExercise;

import java.util.Scanner;

/*
Now you are aware of a Class which is probably a bad practice to use. Anyway, it is a nice example of using generics.
Our next task is to create another Tuple. This time, our task is harder.
Create a Class Threeuple. Its name is telling us, that it will hold no longer, just a pair of objects. The task is
simple, our Threeuple should hold three objects. Make it have getters and setters. You can even extend the previous
class


Input
The input consists of three lines:

The first one is holding a name, an address and a town. Format of the input:
<<first name> <last name>> <address> <town>

The second line is holding a name, beer liters, and a Boolean variable - drunk or not. Format:
<name> <liters of beer> <drunk or not>

The last line will hold a name, a bank balance (double) and a bank name. Format:
<name> <account balance> <bank name>


Output
Print the Threeuples’ objects in format: {firstElement} -> {secondElement} -> {thirdElement}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Threeuple<String, String, String> first = new Threeuple<>(input[0] + " " + input[1], input[2], input[3]);
        System.out.println(first.toString());

        input = scanner.nextLine().split("\\s+");
        Threeuple<String, Integer, Boolean> second = null;
        boolean condition = true;
        if (input[2].equals("not")) {
            second = new Threeuple<>(input[0], Integer.parseInt(input[1]), false);
        }
        second = new Threeuple<>(input[0], Integer.parseInt(input[1]), true);
        System.out.println(second);


        input = scanner.nextLine().split("\\s+");
        Threeuple<String, Double, String> third = new Threeuple<>(input[0], Double.parseDouble(input[1]), input[2]);
        System.out.println(third.toString());
    }
}
