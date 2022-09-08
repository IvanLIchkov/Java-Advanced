package StacksAndQueues_3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] children=scan.nextLine().split("\\s+");
        int n= Integer.valueOf(scan.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String child : children) {
            queue.offer(child);
        }
        while (queue.size()>1){
            for (int i = 1; i < n ; i++) {
                queue.offer(queue.poll());
            }
                System.out.println("Removed "+queue.pop());

        }
        System.out.println("Last is "+queue.poll());

    }
}
