package CatLadyExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Ginka has many cats in her house of various breeds, since some breeds have specific characteristics, Ginka needs some
way to catalogue the cats, help her by creating a class hierarchy with all her breeds of cats so that she can easily
check on their characteristics.
 Ginka has 3 specific breeds of cats "Siamese", "Cymric" and the very famous bulgarian breed "Street Extraordinaire",
each breed has a specific characteristic about which information should be kept. For the Siamese cats their ear size
should be kept, for Cymric cats - the length of their fur in milimeters and for the Street Extraordinaire the decibels
of their meowing during the night.
From the console you will receive lines of cat information until the command "End" is received, the information will
come in one of the following formats:
"Siamese <name> <earSize>"
"Cymric <name> <furLength>"
"StreetExtraordinaire <name> <decibelsOfMeows"
On the last line after the "End" command you will receive the name of a cat, you should print that cat. Round the
numbers two digits after the decimal separator.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Cat> allTheCats = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String breed = tokens[0];
            String name = tokens[1];
            double customSpec = Double.parseDouble(tokens[2]);

            switch (breed) {
                case "Siamese":
                    Siamese siamese = new Siamese(name, breed, customSpec);
                    allTheCats.put(siamese.getName(), siamese);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(name, breed, customSpec);
                    allTheCats.put(cymric.getName(), cymric);
                    break;
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetCat = new StreetExtraordinaire(name, breed, customSpec);
                    allTheCats.put(streetCat.getName(), streetCat);
                    break;
            }

            input = scanner.nextLine();
        }

        String getCat = scanner.nextLine();

        allTheCats.get(getCat).Printer();
    }
}
