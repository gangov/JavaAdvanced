package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        boolean hasSalad = false;
        int toRemove = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                hasSalad = true;
                toRemove = i;
            }
        }
        if (hasSalad) {
            this.data.remove(toRemove);
        }
        return hasSalad;
    }

    public String getHealthiestSalad() {
        String name = "";
        int calories = Integer.MAX_VALUE;

        for (Salad datum : data) {
            if (datum.getTotalCalories() < calories) {
                calories = datum.getTotalCalories();
                name = datum.getName();
            }
        }
        return name;
    }

    public String generateMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s have %d salads:%n", this.name, this.data.size()));
        for (Salad datum : data) {
            sb.append(datum);
        }
        return sb.toString();
    }
}
