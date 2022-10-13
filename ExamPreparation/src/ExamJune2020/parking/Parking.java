package ExamJune2020.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car){
        if (data.size()<capacity){
            data.add(car);
        }
    }
    public boolean remove(String manufacturer,String model){
        if (data.removeIf(c->c.getManufacturer().equals(manufacturer)&&c.getModel().equals(model))){
            return true;
        }
        return false;
    }
    public Car getLatestCar(){
        Car car=data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
        return car;
    }
    public Car getCar(String manufacturer,String model){
        Car car=data.stream()
                .filter(c->c.getManufacturer().equals(manufacturer)&&c.getModel().equals(model))
                .findAny()
                .orElse(null);
        return car;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder output=new StringBuilder(String.format("The cars are parked in %s:%n",this.type));
        for (Car datum : data) {
            output.append(datum).append(System.lineSeparator());
        }
        return String.valueOf(output);
    }
}
