package FunctionalProgramming_12_exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers=Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        UnaryOperator<List<Integer>> addFunction= numbersList-> numbersList.stream()
                .map(el->el+1)
                .collect(Collectors.toList());
        UnaryOperator<List<Integer>>multiplyFunction=numbersList->numbersList.stream()
                .map(el->el*2)
                .collect(Collectors.toList());
        UnaryOperator<List<Integer>>subtractFunction=numbersList->numbersList.stream()
                .map(el->el-1)
                .collect(Collectors.toList());
        Consumer<List<Integer>> print=numbersList->numbersList.stream().forEach(e-> System.out.printf("%s ",e));


        String input= scan.nextLine();
        while (!input.equals("end")){
            switch (input){
                case "add":
                   numbers= addFunction.apply(numbers);
                    break;
                case "multiply":
                  numbers=  multiplyFunction.apply(numbers);
                    break;
                case "subtract":
                  numbers=  subtractFunction.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
                default:
                    throw new IllegalArgumentException("no such argument "+input);

            }
            input= scan.nextLine();
        }
    }
}
