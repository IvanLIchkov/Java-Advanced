package ExamFebruary2021.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    public void add(Car car){
        if (data.size()<capacity){
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model){
        if (data.removeIf(c->c.getManufacturer().equals(manufacturer)&&c.getModel().equals(model))){
            return true;
        }
        return false;
    }
    public Car getLatestCar(){
        return data.stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }
    public Car getCar(String manufacturer, String model){
        return data.stream()
                .filter(c->c.getManufacturer().equals(manufacturer)&&c.getModel().equals(model))
                .findAny()
                .orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder output=new StringBuilder(String.format("The cars are in a car dealership %s:%n",this.name));
        data.forEach(c->output.append(c).append(System.lineSeparator()));
        return String.valueOf(output);
    }
}
