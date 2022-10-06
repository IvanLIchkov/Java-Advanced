package Generics_18_exc.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        String firstName = input[0];
        String secondName = input[1];
        String address = input[2];
        Tuple<String, String> tuple = new Tuple<>(firstName + " " + secondName, address);
        System.out.println(tuple);

        input = scan.nextLine().split(" ");
        String name = input[0];
        int beerLiters =Integer.parseInt(input[1]);
        Tuple<String, Integer> tuple2=new Tuple<>(name, beerLiters);
        System.out.println(tuple2);

        input = scan.nextLine().split(" ");
        int intNumber =Integer.parseInt(input[0]);
        double doubleNumber=Double.parseDouble(input[1]);
        Tuple<Integer, Double> tuple3=new Tuple<>(intNumber, doubleNumber);
        System.out.println(tuple3);

    }
}
