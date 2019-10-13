package GoogleExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

/*
Google is always watching you, so it should come as no surprise that they know everything about you (even your pokemon
collection), since you’re a really good at writing classes Google asked you to design a Class that can hold all the
information they need for people.
From the console you will receive an unkown amount of lines until the command "End" is red, on each of those lines there
will be information about a person in one of the following formats:
"<Name> company <companyName> <department> <salary>"
"<Name> pokemon <pokemonName> <pokemonType>"
"<Name> parents <parentName> <parentBirthday>"
"<Name> children <childName> <childBirthday>"
"<Name> car <carModel> <carSpeed>"
You should structure all information about a person in a class with nested subclasses. People names are unique - there
won’t be 2 people with the same name, a person can also have only 1 company and car, but can have multiple parents,
chidlren and pokemons. After the command "End" is received on the next line you will receive a single name, you should
print all information about that person. Note that information can change during the input, for instance if we receive
multiple lines which specify a person company, only the last one should be the one remembered. The salary must be
formated to two decimal places after the seperator.
Note: print the information in format:
	{personName}
	Company:
	{companyName} {companyDepartment} {salary}
	...
	Children:
	{childName} {childBirthday}
	{childName} {childBirthday}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Person> allPeople = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String classToUse = tokens[1];
            String className = tokens[2];
            String fourthParam = tokens[3];
            double salary = 0;
            if (tokens.length == 5) {
                salary = Double.parseDouble(tokens[4]);
            }

            Person person = new Person(name);
            allPeople.putIfAbsent(person.getName(), person);
            switch (classToUse) {
                case "company":
                    Company company = new Company(className, fourthParam, salary);
                    allPeople.get(person.getName()).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(className, fourthParam);
                    allPeople.get(person.getName()).updatePokemonCollection(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(className, fourthParam);
                    allPeople.get(person.getName()).updateParents(parent);
                    break;
                case "children":
                    Child child = new Child(className, fourthParam);
                    allPeople.get(person.getName()).updateChildren(child);
                    break;
                case "car":
                    Car car = new Car(className, fourthParam);
                    allPeople.get(person.getName()).setCar(car);
                    break;
            }



            input = scanner.nextLine();
        }

        String nameToShow = scanner.nextLine();

        allPeople.get(nameToShow).printingTheEnd();
    }
}
