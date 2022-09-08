package StacksAndQueues_3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String commands= scan.nextLine();
        ArrayDeque<String> queue=new ArrayDeque<>();
        while (!commands.equals("print")){
            if (commands.equals("cancel")){
                if (queue.size()==0){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled "+queue.peek());
                    queue.remove();
                }
            }else{
                queue.offer(commands);
            }
            commands= scan.nextLine();
        }
        for (String s : queue) {
            System.out.println(s);
        }

    }
}
