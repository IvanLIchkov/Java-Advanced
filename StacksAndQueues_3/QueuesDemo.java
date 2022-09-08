package StacksAndQueues_3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class QueuesDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int element=Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        queue.add(element);
        queue.offer(element);//TODO ако искаме да използваме дека като опашка задължително използваме queue.offer(element), защото може да се обаркаме със Stack
        queue.peek(); // за проверка кой елемент е първи на опашката
        queue.remove(element);// за премахане на елементи

    }
}
