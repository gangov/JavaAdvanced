package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        int sum = 0;
        for (Vegetable product : this.products) {
            sum += product.getCalories();
        }

        return sum;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* Salad %s is %d calories and have %d products:%n",
                this.name,
                this.getTotalCalories(),
                this.getProductCount()));
        for (Vegetable product : products) {
            sb.append(product);
            sb.append(System.lineSeparator()).trimToSize();
        }
        return sb.toString();
    }
}
