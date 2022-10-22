package MyExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> caffeine = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(caffeine::push);
        ArrayDeque<Integer> drinks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(drinks::offer);
        int totalCaffeine = 0;
        while (caffeine.size() != 0 && drinks.size() != 0) {
            int sum = caffeine.peek() * drinks.peek();
            if (sum + totalCaffeine <= 300) {
                caffeine.pop();
                drinks.remove();
                totalCaffeine += sum;
            } else {
                caffeine.pop();
                int temp = drinks.peek();
                drinks.remove();
                drinks.addLast(temp);
                if (totalCaffeine > 31) {
                    totalCaffeine -= 30;
                }
            }
        }
        if (drinks.size() > 0) {
            System.out.print("Drinks left: ");
            System.out.println(drinks.stream().map(d -> d + "").collect(Collectors.joining(", ")));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);
    }
}
