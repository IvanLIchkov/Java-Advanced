package StackAndQueues_4_exe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> reversedOrder = new ArrayDeque<>();
        for (int number : numbers) {
            reversedOrder.push(number);
        }
        for (Integer integer : reversedOrder) {
            System.out.print(integer + " ");
        }
    }
}
