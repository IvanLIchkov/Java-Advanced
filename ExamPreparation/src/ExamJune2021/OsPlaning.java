package ExamJune2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OsPlaning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input= Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> task=new ArrayDeque<>();
        for (int i : input) {
            task.push(i);
        }
        input= Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> thread=new ArrayDeque<>();
        for (int i : input) {
            thread.offer(i);
        }
        int taskValueForKill=Integer.parseInt(scan.nextLine());
        while (thread.size()!=0){
            if (task.peek()==taskValueForKill){
                System.out.printf("Thread with value %d killed task %d%n",thread.peek(),taskValueForKill);
                for (Integer integer : thread) {
                    System.out.printf("%d ",integer);
                }
                return;
            } else if (thread.peek()>=task.peek()){
                task.pop();
                thread.remove();
            }else if (thread.peek()<task.peek()){
                thread.remove();
            }
        }
    }
}
