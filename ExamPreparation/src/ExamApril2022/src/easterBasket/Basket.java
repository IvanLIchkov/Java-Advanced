package ExamApril2022.src.easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return data.removeIf(e -> e.getColor().equals(color));
    }

    public Egg getStrongestEgg() {

        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder(String.format("%s basket contains:%n", this.material));
        data.forEach(e -> output.append(e.toString()).append(String.format("%n")));
        return String.valueOf(output).trim();
    }
}
