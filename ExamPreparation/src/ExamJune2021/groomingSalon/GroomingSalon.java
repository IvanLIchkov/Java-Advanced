package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    public int capacity;
    public List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        if (data.removeIf(p -> p.getName().equals(name))) {
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findAny()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The grooming salon has the following clients:\n");
        data.forEach(p -> output.append(String.format("%s %s", p.getName(), p.getOwner())).append(System.lineSeparator()));
        return String.valueOf(output);
    }
}
