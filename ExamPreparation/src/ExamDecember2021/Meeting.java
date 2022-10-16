package ExamDecember2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(input).forEach(males::push);
        input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(input).forEach(females::offer);
        int matches = 0;
        while (females.size() != 0 && males.size() != 0) {
            if (females.peek() <= 0 || males.peek() <= 0) {
                if (males.peek() <= 0) {
                    males.pop();
                }
                if (females.peek() <= 0) {
                    females.remove();
                }
            } else if (isDivisibleBy25(females.peek())) {
                females.remove();
                females.remove();
            } else if (isDivisibleBy25(males.peek())) {
                males.pop();
                males.pop();
            } else {
                if (Objects.equals(females.peek(), males.peek())) {
                    females.remove();
                    males.pop();
                    matches++;
                } else {
                    females.remove();
                    int manValue = males.peek();
                    males.pop();
                    males.addFirst(manValue - 2);
                }
            }
        }
        System.out.println("Matches: " + matches);
        if (males.size() == 0) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            printDeque(males);
        }
        if (females.size() == 0) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            printDeque(females);
        }
    }

    private static void printDeque(ArrayDeque<Integer> males) {
        System.out.println(males.stream().map(e -> e + "").collect(Collectors.joining(", ")));
    }

    private static boolean isDivisibleBy25(Integer integer) {
        if (integer % 25 == 0) {
            return true;
        }
        return false;
    }
}
