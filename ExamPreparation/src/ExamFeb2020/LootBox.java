package ExamFeb2020;

import java.util.*;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] integers = scan.nextLine().split(" ");
        for (String stackInteger : integers) {
            stack.offer(Integer.parseInt(stackInteger));
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        integers = scan.nextLine().split(" ");
        for (String integer : integers) {
            queue.push(Integer.parseInt(integer));
        }
        int value = 0;
        while (stack.size() != 0 && queue.size() != 0) {
            int number=stack.peek()+queue.peek();
            if (number % 2 == 0) {
                value += (stack.poll() + queue.pop());
            } else {
                stack.offerLast(queue.peek());
                queue.remove();
            }
        }
        if (stack.size() <= 0) {
            System.out.println("First lootbox is empty");
            checkPoints(value);
        } else if (queue.size() <= 0) {
            System.out.println("Second lootbox is empty");
            checkPoints(value);
        }

    }

    private static void checkPoints(int value) {
        if (value >= 100) {
            System.out.printf("Your loot was epic! Value: %d", value);
        } else {
            System.out.printf("Your loot was poor... Value: %d", value);
        }
    }
}
