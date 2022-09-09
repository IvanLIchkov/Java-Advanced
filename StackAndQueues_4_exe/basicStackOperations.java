package StackAndQueues_4_exe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class basicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numbers[0]; i++) {
            stack.push(scan.nextInt());
        }
        for (int i = 0; i < numbers[1]; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(numbers[2])) {
                System.out.println("true");
            } else {
                int minValue = Integer.MAX_VALUE;
                for (Integer integer : stack) {
                    if (integer < minValue) {
                        minValue = integer;
                    }

                }
                System.out.println(minValue);
            }
        }
    }
}
