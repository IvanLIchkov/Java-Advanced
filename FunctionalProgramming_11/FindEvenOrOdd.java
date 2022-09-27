package FunctionalProgramming_11;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvenOrOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] range=Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String condition= scan.nextLine();
        int low=range[0];
        int up=range[1];

        System.out.println(IntStream.rangeClosed(low, up)
                .boxed()
                .filter(integerPredicate(condition))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
    public static Predicate<Integer> integerPredicate(String condition){
        if (condition.equals("odd")){
            return n->n%2!=0;
        }else{
            return n->n%2==0;
        }
    }
}
