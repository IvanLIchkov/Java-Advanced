package DefiningClasses_13.CarInfo_01;

import DefiningClasses_13.CarInfo_01.Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int carsCount = Integer.parseInt(scan.nextLine());
        while (carsCount-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);
            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            System.out.println(car.carInfo());

        }

    }
}
