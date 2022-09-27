package FunctionalProgramming_11;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        Function<Double, Double> addVat = p -> p * 1.20; //function is the same thing as UnaryOperator just function has two parameters from the same
        //type can be replaced with UnaryOperator who has only one type.
        UnaryOperator<Double> addVat = p -> p * 1.20;//same as function with two same parameters.

        Consumer<Double> printer = d -> System.out.printf("%.2f%n", d);

        System.out.println("Prices with VAT:");
        Arrays.stream(scan.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(printer);
    }
}
