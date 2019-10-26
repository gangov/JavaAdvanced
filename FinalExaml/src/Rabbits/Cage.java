package Rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        boolean result = false;
        int index = 0;
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                result = true;
                break;
            }
            index++;
        }

        if (result) {
            this.data.remove(index);
        }
        return result;
    }

    public void removeSpecies(String species) {
        ArrayList<Integer> locations = new ArrayList<>();
        int index = 0;
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                locations.add(index);
            }
            index++;
        }

        for (Integer location : locations) {
            this.data.remove(location);
        }
    }

    public Rabbit sellRabbit(String name) {
        int index = 0;
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                break;
            }
            index++;
        }

        return this.data.get(index);
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        ArrayList<Rabbit> selected = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                selected.add(rabbit);
                rabbit.setAvailable(false);
            }
        }
        return selected;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:%n", this.getName()));
        for (Rabbit rabbit : this.data) {
            sb.append(rabbit.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

