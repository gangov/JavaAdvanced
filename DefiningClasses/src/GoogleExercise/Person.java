package GoogleExercise;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonCollection;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public String getName() { return name; }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void updatePokemonCollection(Pokemon theNewPokemon) {
        this.pokemonCollection.add(theNewPokemon);
    }

    public StringBuilder allPokemonsListed() {
        StringBuilder allPokemonsInOne = new StringBuilder();
        for (Pokemon pokemon : pokemonCollection) {
            allPokemonsInOne.append(pokemon.getName());
            allPokemonsInOne.append(" ");
            allPokemonsInOne.append(pokemon.getType());
            allPokemonsInOne.append(System.lineSeparator());
        }
        return allPokemonsInOne;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public StringBuilder allParentsListed() {
        StringBuilder allParentsInOne = new StringBuilder();
        for (Parent parent : parents) {
            allParentsInOne.append(parent.getName());
            allParentsInOne.append(" ");
            allParentsInOne.append(parent.getBirthday());
            allParentsInOne.append(System.lineSeparator());
        }
        return allParentsInOne;
    }

    public void updateParents(Parent theNewParent) {
        this.getParents().add(theNewParent);
    }

    public void updateChildren(Child theNewChild) {
        this.children.add(theNewChild);
    }

    public StringBuilder allChildrenListed() {
        StringBuilder allChildrenInOne = new StringBuilder();
        for (int i = 0; i < this.children.size(); i++) {
            if (i == this.children.size() - 1) {
                allChildrenInOne.append(this.children.get(i).getName());
                allChildrenInOne.append(" ");
                allChildrenInOne.append(this.children.get(i).getBirthday());
            } else {
                allChildrenInOne.append(this.children.get(i).getName());
                allChildrenInOne.append(" ");
                allChildrenInOne.append(this.children.get(i).getBirthday());
                allChildrenInOne.append(System.lineSeparator());
            }
        }
        return allChildrenInOne;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person(String name) {
        this.name = name;
        this.pokemonCollection = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void printingTheEnd() {
        System.out.println(this.name);

        System.out.println("Company:");
        if (this.company != null) {
            System.out.println(this.company.toString());
        }

        System.out.println("Car:");
        if (this.car != null) {
            System.out.println(this.car.toString());
        }

        System.out.println("Pokemon:");
        this.pokemonCollection.forEach(p -> System.out.println(p.toString()));

        System.out.println("Parents:");
        this.parents.forEach(parent -> System.out.println(parent.toString()));

        System.out.println("Children:");
        this.children.forEach(child -> System.out.println(child.toString()));
    }
}
