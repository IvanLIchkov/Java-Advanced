package DefiningClasses_14_exc;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Car> cars=new ArrayList<>();
        int numberOfCars=Integer.parseInt(scan.nextLine());
        for (int i = 0; i <numberOfCars ; i++) {
            String[] tokens=scan.nextLine().split("\\s+");
            String model=tokens[0];
            int fuel=Integer.parseInt(tokens[1]);
            double fuelConsumption=Double.parseDouble(tokens[2]);
            cars.add(new Car(model,fuel,fuelConsumption));
        }
        String command= scan.nextLine();
        while (!command.equals("End")){
            String[] tokens=command.split("\\s+");
            String model=tokens[1];
            int amountOfKm=Integer.parseInt(tokens[2]);
            for (Car car : cars) {
                if (car.getModel().equals(model)){
                    if (car.canCarMoveDistance(amountOfKm)){
                        car.changeKm(amountOfKm);
                    }else{
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
            command= scan.nextLine();
        }
        for (Car car : cars) {
            System.out.println(car.toString());
        }

    }
}
