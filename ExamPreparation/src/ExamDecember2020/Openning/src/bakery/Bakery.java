package ExamDecember2020.Openning.src.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        if (employees.removeIf(e -> e.getName().equals(name))) {
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder("Employees working at Bakery " + this.name + ":\n");
        for (Employee employee : employees) {
            output.append(employee).append(System.lineSeparator());
        }
        return String.valueOf(output);
    }
}
