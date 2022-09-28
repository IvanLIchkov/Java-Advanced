package FunctionalProgramming_12_exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        UnaryOperator<String> word = s -> "Sir " + s;
        Consumer<String> print=s-> System.out.println(s);
        names.stream().map(word).forEach(print);
    }
}
