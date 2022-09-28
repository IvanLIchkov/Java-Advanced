package FunctionalProgramming_12_exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());
        List<String> names = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        Predicate<String> predicate=name->name.length()<=n;
        names.stream().filter(predicate).forEach(System.out::println);
    }
}
