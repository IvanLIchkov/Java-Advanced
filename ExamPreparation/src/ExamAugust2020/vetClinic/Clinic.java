package ExamAugust2020.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> pets;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.pets = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (pets.size() < capacity) {
            pets.add(pet);
        }
    }

    public boolean remove(String name) {
        if (pets.removeIf(p->p.getName().equals(name))){
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet pet=pets.stream()
                .filter(p->p.getName().equals(name)&&p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
        return pet;
    }
    public Pet getOldestPet(){
        Pet pet=pets.stream()
                .max(Comparator.comparing(Pet::getAge))
                .get();
        return pet;
    }
    public int getCount(){
        return this.pets.size();
    }
    public String getStatistics(){
        StringBuilder output=new StringBuilder("The clinic has the following patients:\n");
        for (Pet pet : pets) {
            output.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return String.valueOf(output);
    }
}
