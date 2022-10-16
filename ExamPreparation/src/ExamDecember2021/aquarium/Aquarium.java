package ExamDecember2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish>fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
    public int getFishInPool(){
        return fishInPool.size();
    }
    public void add(Fish fish){
        if (fishInPool.stream().noneMatch(f->f.equals(fish))){
            fishInPool.add(fish);
        }
    }
    public boolean remove(String name){
        return  fishInPool.removeIf(f->f.getName().equals(name));
    }
    public Fish findFish(String name){
        return fishInPool.stream()
                .filter(f->f.getName().equals(name))
                .findAny()
                .orElse(null);
    }
    public String report(){
        StringBuilder output=new StringBuilder(String.format("Aquarium: %s ^ Size: %d%n",this.name,this.size));
        fishInPool.forEach(f->output.append(f.toString()).append(System.lineSeparator()));
        return String.valueOf(output);
    }
}
