package FunctionalProgramming_11;

import java.util.Arrays;
import java.util.Scanner;

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
    }
}
