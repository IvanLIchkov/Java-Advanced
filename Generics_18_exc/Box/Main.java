package Generics_18_exc.Box;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            Double element = Double.parseDouble(scan.nextLine());
            box.add(element);
        }
//        int[] indexes= Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int firstIndex=indexes[0];
//        int secondIndex=indexes[1];
//        box.swap(firstIndex, secondIndex);
        Double elementToCompare= Double.parseDouble(scan.nextLine());

        System.out.println(box.countGreaterItems(elementToCompare));
    }
}
