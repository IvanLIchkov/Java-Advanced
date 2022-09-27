package FunctionalProgramming_11;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalProgramingDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Method:
        //return type -> double
        //name -> getPowerOf
        //parameters list -> (int x, int pow)
        //signature -> getPowerOf(int , int)
        //body -> {return Math.pow(x, pow);}


        int[] arr={13, 42, 69, 73};
        int pow=2;

        Arrays.stream(arr)
                .mapToDouble((n) -> Math.pow(n,pow))
                .forEach(System.out::println);

        Consumer<Integer> a;//doesn't get result back
        Supplier<Integer>s;//returning result
        Predicate<Integer>p;//get boolean back
    }
}
