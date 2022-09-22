package SetsAndMapsAdvanced_7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3nNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}
