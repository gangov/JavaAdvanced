package PokemonTrainerExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    //name, number of badges and a collection of pokemon
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonCollection;



    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public void setPokemonCollection(List<Pokemon> pokemonCollection) {
        this.pokemonCollection = pokemonCollection;
    }



    //constructor
    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonCollection = new ArrayList<>();
    }


    //methods
    public boolean hasSuchPokemonType(String type) {
        return this.getPokemonCollection().stream().anyMatch(p -> p.getElement().equals(type));
    }

    public void decreasePokemonHealth() {
        this.pokemonCollection = this.pokemonCollection
                .stream()
                .peek(Pokemon::decreaseHealth)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());

    }

    public void increaseBadges() {
        this.numberOfBadges += 1;
    }
}
