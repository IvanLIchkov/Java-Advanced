package ExamAugust2021.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        if (employees.size()<capacity){
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){
        if (employees.removeIf(e->e.getName().equals(name))){
            return true;
        }
        return false;
    }
    public Employee getOldestEmployee(){
        return employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }
    public Employee getEmployee(String name){
        return employees.stream()
                .filter(e->e.getName().equals(name))
                .findAny()
                .orElse(null);
    }
    public int getCount(){
        return this.employees.size();
    }
    public String report(){
        StringBuilder output=new StringBuilder("Employees working at Cafe "+this.name+":\n");
        employees.forEach(e->output.append(e.toString()).append(System.lineSeparator()));
        return String.valueOf(output);
    }
}
