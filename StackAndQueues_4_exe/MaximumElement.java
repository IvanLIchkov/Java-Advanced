package StackAndQueues_4_exe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int numberOfOperations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfOperations; i++) {
            int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            switch (numbers[0]) {
                case 1:
                    stack.push(numbers[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int max = Integer.MIN_VALUE;
                    for (Integer integer : stack) {
                        if (integer > max) {
                            max = integer;
                        }
                    }
                    System.out.println(max);
                    break;
            }
        }
    }
}
