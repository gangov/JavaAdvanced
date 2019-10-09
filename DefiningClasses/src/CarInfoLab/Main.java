package CarInfoLab;

import java.util.Scanner;
/*
Create a class named Car.
The class should have public fields for:
Make: String
Model: String
Horse Power: int
Create a new class and ensure proper naming
This method should return the info about any car object in the following format:
"The car is: {made} {model} – {horsePower} HP."
You have to figure out how to create a method and to use it in the outside code as shown below

Test The Program
Read a cars objects, add them to collection of your chose and the print each one on the console using the carInfo()
method. The input consists of single integer N the number of lines representing car objects. One each line you will read
car info in the following format {make}  {model} {horsePower} separated by single space.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String make = input[0];
            String model = input[1];
            int horsePower = Integer.parseInt(input[2]);

            Car current = new Car();
            current.setMake(make);
            current.setModel(model);
            current.setHorsePower(horsePower);

            current.carInfo();
        }
    }
}
