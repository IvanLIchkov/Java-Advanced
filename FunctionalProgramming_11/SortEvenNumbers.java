package FunctionalProgramming_11;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        String output = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);

        System.out.println(numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
