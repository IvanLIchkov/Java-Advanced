package DefiningClasses_14_exc.CarSalesMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (tokens.length == 2) {
                String model = tokens[0];
                String power = tokens[1];
                engines.add(new Engine(model, power));
            } else if (tokens.length == 3) {
                String model = tokens[0];
                String power = tokens[1];
                if (tokens[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engines.add(new Engine(model, power, displacement));
                } else {
                    String efficiency = tokens[2];
                    engines.add(new Engine(model, power, efficiency));
                }
            } else if (tokens.length == 4) {
                String model = tokens[0];
                String power = tokens[1];
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engines.add(new Engine(model, power, displacement, efficiency));
            }
        }
        int numberOfCars = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (tokens.length == 2) {
                String model = tokens[0];
                String engine = tokens[1];
                Engine engine1 = engines.stream().filter(e -> e.getModel().equals(engine)).findFirst().get();

                cars.add(new Car(model, engine1));
            } else if (tokens.length == 3) {
                String model = tokens[0];
                String engine = tokens[1];
                Engine engine1 = engines.stream().filter(e -> e.getModel().equals(engine)).findFirst().get();
                if (tokens[2].matches("\\d+")) {
                    int weight = Integer.parseInt(tokens[2]);
                    cars.add(new Car(model, engine1, weight));
                } else {
                    String color = tokens[2];
                    cars.add(new Car(model, engine1, color));
                }
            } else if (tokens.length == 4) {
                String model = tokens[0];
                String engine = tokens[1];
                Engine engine1 = engines.stream().filter(e -> e.getModel().equals(engine)).findFirst().get();
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                cars.add(new Car(model, engine1, weight, color));
            }
        }
        cars.stream().forEach(e -> System.out.println(e.toString()));

    }
}
