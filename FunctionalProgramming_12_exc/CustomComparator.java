package FunctionalProgramming_12_exc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Comparator<Integer> comparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            } else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            } else {
                return num1.compareTo(num2);
            }
        };
        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(number -> System.out.printf("%d ", number));
    }
}
