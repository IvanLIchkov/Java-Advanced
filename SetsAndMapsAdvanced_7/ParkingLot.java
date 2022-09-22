package SetsAndMapsAdvanced_7;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input=scan.nextLine().split(", ");
        LinkedHashSet<String> cars=new LinkedHashSet<>();
        while (!input[0].equals("END")){
            if (input[0].equals("IN")){
                cars.add(input[1]);
            } else if (input[0].equals("OUT")) {
                cars.remove(input[1]);
            }


            input=scan.nextLine().split(", ");
        }
        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            System.out.println(String.join(System.lineSeparator(), cars));
        }
    }
}
