package StackAndQueues_4_exe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numbers[0]; i++) {
            queue.offer(Integer.parseInt(scan.next()));
        }
        for (int i = 0; i < numbers[1]; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(numbers[2])) {
                System.out.println(true);
            } else {
                int min = Integer.MAX_VALUE;
                for (Integer integer : queue) {
                    if (integer < min) {
                        min = integer;
                    }
                }
                System.out.println(min);
            }
        }
    }
}
