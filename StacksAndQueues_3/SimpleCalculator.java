package StacksAndQueues_3;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);
        while (stack.size()>1){
            int first =Integer.parseInt(stack.pop());
            String op=stack.pop();
            int second=Integer.parseInt(stack.pop());

            switch (op){
                case "+": stack.push(String.valueOf(first+second));
                break;
                case "-": stack.push(String.valueOf(first-second));
                break;
            }
        }
        System.out.println(stack.pop());
    }
}
