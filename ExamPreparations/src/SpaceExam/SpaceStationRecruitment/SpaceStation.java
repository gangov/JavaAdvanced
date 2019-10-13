package SpaceExam.SpaceStationRecruitment;

import java.util.*;

public class SpaceStation {
    private String name;
    private int capacity;
    private List<Astronaut> astronautsList;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.astronautsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.astronautsList.size();
    }

    public void add(Astronaut astronaut) {
        if (this.astronautsList.size() < this.capacity) {
            this.astronautsList.add(astronaut);
        }
    }

    public void remove(String name) {
        int index = 0;
        boolean wasSuccessful = false;
        for (int i = 0; i < this.astronautsList.size(); i++) {
            if (this.astronautsList.get(i).getName().equals(name)) {
                index = i;
                wasSuccessful = true;
            }
        }
        if (wasSuccessful) {
            this.astronautsList.remove(index);
        }
        System.out.println(wasSuccessful);
    }

    public Astronaut getOldestAstronaut() {
        return this.astronautsList.stream().max(Comparator.comparing(Astronaut::getAge))
                .orElseThrow(NoSuchElementException::new);
    }

    public Astronaut getAstronaut(String name) {
        int index = 0;
        Astronaut m = null;
        for (Astronaut astronaut : this.astronautsList) {
            if (astronaut.getName().equals(name)) {
                m = astronaut;
            }
            index++;
        }
        return m;
    }

    public void report() {
        System.out.println("Astronauts working at Space Station " + this.getName() + ":");
        this.astronautsList.forEach(a -> System.out.println(a.toString()));
    }
}
