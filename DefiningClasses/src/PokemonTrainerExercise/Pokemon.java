package PokemonTrainerExercise;

public class Pokemon {
    private String name;
    private String element;
    private int health;
    private boolean isAlive;



    //getters and setters
    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }




    //constructor
    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }


    //methods
    public void decreaseHealth() {
        this.health -= 10;
    }
}
