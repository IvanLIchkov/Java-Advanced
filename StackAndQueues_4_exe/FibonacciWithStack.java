package StackAndQueues_4_exe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FibonacciWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n=Long.parseLong(scan.nextLine());
        if (n<2){
            System.out.println(1);
            return;
        }
        ArrayDeque<Long> stack=new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);
        for (int i = 1; i <n ; i++) {
            long secondNum=stack.pop();
            long firstNum=stack.pop();
            stack.push(secondNum);
            stack.push(firstNum+secondNum);
        }
        System.out.println(stack.peek());
    }
}
