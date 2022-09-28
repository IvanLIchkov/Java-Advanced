package FunctionalProgramming_12_exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());
        List<Integer> numbers= Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Predicate<Integer> isDivisible=number->{
            for (Integer numberToDivide : numbers) {
                if (number%numberToDivide!=0){
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <=n ; i++) {
            if (isDivisible.test(i)){
                System.out.print(i+" ");
            }
        }
    }
}
