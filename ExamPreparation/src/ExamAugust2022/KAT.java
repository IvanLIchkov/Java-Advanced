package ExamAugust2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> plates = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(plates::offer);
        ArrayDeque<Integer> cars = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(cars::push);
        int carCounter = 0;
        int dayCounter = 0;
        while (plates.size() != 0 && cars.size() != 0) {
            dayCounter++;
            int platesNumbers = plates.peek();
            int carsNumbers = cars.peek();
            if (platesNumbers / 2 == carsNumbers) {
                carCounter += cars.peek();
                plates.remove();
                cars.pop();
            } else if (platesNumbers / 2 > carsNumbers) {
                carCounter += cars.peek();
                cars.pop();
                int remain = platesNumbers - carsNumbers * 2;
                plates.remove();
                plates.addLast(remain);
            } else if (platesNumbers / 2 < carsNumbers) {
                carCounter += platesNumbers / 2;
                plates.remove();
                int remain = carsNumbers - platesNumbers / 2;
                cars.pop();
                cars.addLast(remain);
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", carCounter, dayCounter);
        if (plates.size() == 0 && cars.size() == 0) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (plates.size() > 0) {
            int platesRemain = 0;
            for (Integer plate : plates) {
                platesRemain += plate;
            }

            System.out.printf("%d license plates remain!", platesRemain);
        } else {
            int carsRemain = 0;
            for (Integer car : cars) {
                carsRemain += car;
            }

            System.out.printf("%d cars remain without license plates!", carsRemain);
        }
    }
}
