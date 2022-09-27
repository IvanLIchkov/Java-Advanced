package FunctionalProgramming_11;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, String> countFormatter=list->"Count = "+list.size();
        Function<List<Integer>, Integer> sumAllElements=list-> list.stream().mapToInt(e->e).sum();

        Function<Integer, String> sumFormatter=s->"Sum = "+s;

        String countOutput= countFormatter.apply(numbers);
        System.out.println(countOutput);
        int sum=sumAllElements.apply(numbers);
        String sumOutput=sumFormatter.apply(sum);
        System.out.println(sumOutput);
    }
}
