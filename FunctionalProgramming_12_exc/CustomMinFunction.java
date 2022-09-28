package FunctionalProgramming_12_exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> smallestInt = (int[] arr) -> {
            int min = Integer.MAX_VALUE;
            for (int i : arr) {
                if (i < min) {
                    min = i;
                }
            }
            return min;
        };
//        Function<int[], Integer>function=arr->Arrays.stream(arr).min().getAsInt(); //TODO същото като горното но по-кратко написано
//        Function<int[], Integer> function2=arr-> Collections.min(Arrays.stream(arr).boxed().collect(Collectors.toList())); //TODO още един начин но този път със големия Integer.
        System.out.println(smallestInt.apply(numbers));
    }
}
