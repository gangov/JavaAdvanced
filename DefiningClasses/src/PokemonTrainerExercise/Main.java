package PokemonTrainerExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
You wanna be the very best pokemon trainer, like no one ever was, so you set out to catch pokemons. Define a class
Trainer and a class Pokemon. Trainer have a name, number of badges and a collection of pokemon. Pokemon have a name, an
element and health, all values are mandatory. Every Trainer starts with 0 badges.
From the console you will receive an unknown number of lines until you receive the command "Tournament", each line will
carry information about a pokemon and the trainer who caught it in the format
"<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>" where TrainerName is the name of the Trainer who caught
the pokemon, names are unique there cannot be 2 trainers with the same name. After receiving the command "Tournament" an
unknown number of lines containing one of three elements "Fire", "Water", "Electricity" will follow until the command
"End" is received. For every command you must check if a trainer has atleast 1 pokemon with the given element, if he
does he receives 1 badge, otherwise all his pokemon lose 10 health, if a pokemon falls to 0 or less health he dies and
must be deleted from the trainer’s collection. After the command "End" is received you should print all trainers sorted
by the amount of badges they have in descending order (if two trainers have the same amount of badges they should be
sorted by order of appearance in the input) in the format "<TrainerName> <Badges> <NumberOfPokemon".
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, Trainer> tournament = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            Trainer gamer = new Trainer(name);

            tournament.putIfAbsent(gamer.getName(), gamer);
            tournament.get(gamer.getName()).getPokemonCollection().add(pokemon);

            input = scanner.nextLine();
        }

        String type = scanner.nextLine();

        while (!type.equals("End")) {

            for (Trainer trainer : tournament.values()) {
                if (trainer.hasSuchPokemonType(type)) {
                    trainer.increaseBadges();
                } else {
                    trainer.decreasePokemonHealth();
                }
            }

            type = scanner.nextLine();
        }

        tournament.values().stream().sorted((t1, t2) -> {
            return Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges());
        }).forEach(trainer -> System.out.println(String.format("%s %d %d", trainer.getName(), trainer.getNumberOfBadges()
                , trainer.getPokemonCollection().size())));
    }
}
