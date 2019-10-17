package TupleExercise;

import java.util.Scanner;

/*
There is something, really annoying in the C# - language. It is called a "Tuple". It is a class, which contains two
objects. The first one is "item1" and the second one is "item2". It is kind of like a Map.Entry except - it simply has
items, which are neither key nor value. The annoyance is coming from the fact, that you have no idea what these objects
are holding. The class name is telling you nothing, the methods which it has – too. So let’s say we could try to
implement it in Java, just for practicing generics.
The task:
Create a class "Tuple", which is holding two objects. Like we said, the first one, will be "item1" and the second one -
"item2". The tricky part here is to make the class hold generics. This means, that when you create a new object of class
 - "Tuple", there should be a way to explicitly, specify both the items type separately.


Input
The input consists of three lines:

The first one is holding a person name and an address. They are separated by space(s). Your task is to collect them in
the tuple and print them on the console. Format of the input:
<<first name> <last name>> <address>

The second line holds a name of a person and the amount of beer he can drink. Format:
<name> <liters of beer>

The last line will hold an Integer and a Double. Format:
<Integer> <Double>


Output
Print the tuples’ items in format: {item1} -> {item2}


Constraints
Use the good practices we have learned. Create the class and make it have getters and setters for its class variables.
The input will be valid, no need to check it explicitly!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String location = input[2];
        Tuple<String, String> firstLine = new Tuple<>(name, location);
        System.out.println(firstLine.toString());

        String[] secondInput = scanner.nextLine().split("\\s+");
        String who = secondInput[0];
        int what = Integer.parseInt(secondInput[1]);
        Tuple<String, Integer> secondLine = new Tuple<>(who, what);
        System.out.println(secondLine.toString());


        String[] thirdInput = scanner.nextLine().split("\\s+");
        int one = Integer.parseInt(thirdInput[0]);
        double two = Double.parseDouble(thirdInput[1]);
        Tuple<Integer, Double> thirdLine = new Tuple<>(one, two);
        System.out.println(thirdLine.toString());
    }
}
