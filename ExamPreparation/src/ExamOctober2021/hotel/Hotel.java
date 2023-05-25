package ExamOctober2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster=new ArrayList<>();
    }
    public void add(Person person){
        if (roster.size()<capacity){
            roster.add(person);
        }
    }
    public boolean remove(String name){
        return roster.removeIf(p->p.getName().equals(name));
    }
    public Person getPerson(String name, String hometown){
        return roster.stream()
                .filter(e->e.getName().equals(name)&&e.getHometown().equals(hometown))
                .findAny()
                .orElse(null);
    }
    public int getCount(){
        return roster.size();
    }
    public String getStatistics(){
        StringBuilder output=new StringBuilder(String.format("The people in the hotel %s are:%n",this.name));
        roster.forEach(p->output.append(p.toString()).append(System.lineSeparator()));
        return String.valueOf(output);
    }
}
