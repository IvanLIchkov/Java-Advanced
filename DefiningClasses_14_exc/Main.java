package DefiningClasses_14_exc;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();
        Map<String, Department> departmentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] employeeInfo = scan.nextLine().split("\\s+");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;
            if (employeeInfo.length == 5) {
                try {
                    int age = Integer.parseInt(employeeInfo[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = employeeInfo[4];
                    employee = (new Employee(name, salary, position, department, email));
                }
            } else if (employeeInfo.length == 4) {
                employee = (new Employee(name, salary, position, department));
            } else if (employeeInfo.length == 6) {
                String email = employeeInfo[4];
                int age = Integer.parseInt(employeeInfo[5]);
                employee = (new Employee(name, salary, position, department, email, age));
            }
            departmentMap.putIfAbsent(department, new Department(department));
            departmentMap.get(department).getEmployees().add(employee);
            employees.add(employee);
        }
        Department highestPaidDepartment = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().calculateAverageSalary()))
                .get()
                .getValue();
        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());
        highestPaidDepartment.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
