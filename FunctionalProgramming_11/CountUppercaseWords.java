package FunctionalProgramming_11;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Predicate<String> isFirstLetterUpperCase =
                word -> Character.isUpperCase(word.charAt(0));
        List<String> uppercaseWord = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(isFirstLetterUpperCase)
                .collect(Collectors.toList());

        System.out.println(uppercaseWord.size());

        Consumer<String> printer= System.out::println;

        uppercaseWord.forEach(printer);

    }
}
