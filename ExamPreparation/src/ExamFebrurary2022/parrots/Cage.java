package ExamFebrurary2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

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
    public void add(Parrot parrot){
        if (data.size()<capacity){
            data.add(parrot);
        }
    }
    public boolean remove(String name){
        if(data.removeIf(p->p.getName().equals(name))){
            return true;
        }
        return false;
    }
    public Parrot sellParrot(String name){
        data.stream().filter(p->p.getName().equals(name))
                .forEach(p->p.setAvailable(false));
        return data.stream().filter(p->p.getName().equals(name))
                .findAny()
                .orElse(null);
    }
    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot>saled=new ArrayList<>();
        data.stream().filter(p->p.getSpecies().equals(species))
                .forEach(p->{
                    sellParrot(p.getName());
                    saled.add(p);
                });
        return saled;
    }
    public int count(){
        return data.size();
    }
    public String report(){
        StringBuilder output=new StringBuilder(String.format("Parrots available at %s:%n",this.name));
        data.stream().filter(Parrot::isAvailable)
                        .forEach(p->output.append(p.toString()).append(System.lineSeparator()));
        return String.valueOf(output);
    }
}
