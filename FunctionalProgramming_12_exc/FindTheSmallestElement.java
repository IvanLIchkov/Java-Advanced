package FunctionalProgramming_12_exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> minElementIndex = integerList -> {
            int minElement = Integer.MAX_VALUE;
            int mindIndex = -1;
            for (int i = 0; i < integerList.size(); i++) {
                if (integerList.get(i) <= minElement) {
                    minElement = integerList.get(i);
                    mindIndex = i;
                }
            }
            return mindIndex;
        };
        System.out.println(minElementIndex.apply(list));
    }
}
