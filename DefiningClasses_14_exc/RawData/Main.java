package DefiningClasses_14_exc.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            Car car;
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            List<Tire> tires = new ArrayList<>();
            int counter = 0;
            for (int j = 0; j < 4; j++) {
                double tirePressure = Double.parseDouble(tokens[5 + counter]);
                int tireAge = Integer.parseInt(tokens[6 + counter]);
                counter += 2;
                tires.add(new Tire(tirePressure, tireAge));
            }
            cars.add(new Car(model, new Engine(engineSpeed, enginePower), new Cargo(cargoWeight, cargoType), tires));
        }
        String command = scan.nextLine();
        if (command.equals("fragile")) {
            cars.removeIf(car -> !car.getCargo().getCargoType().equals("fragile"));
            cars.removeIf(car -> !car.isPressureUnder1());
        } else if (command.equals("flamable")) {
            cars.removeIf(car -> !car.getCargo().getCargoType().equals("flamable"));
            cars.removeIf(car -> !car.isEnginePowerMoreThan());
        }
        cars.stream()
                .forEach(car -> System.out.println(car.getModel()));
    }
}
