package StacksAndQueues_3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Priority_Queue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer>  queue=new PriorityQueue<>(Comparator.reverseOrder());
        //TODO чрез този начин ние можем сами да определим в какъв ред да ни са подредени
        queue.offer(42);
        queue.offer(13);
        queue.offer(73);
        queue.offer(69);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
