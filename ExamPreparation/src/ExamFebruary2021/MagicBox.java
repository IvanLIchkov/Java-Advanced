package ExamFebruary2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input= Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> firstBox=new ArrayDeque<>();
        for (int i : input) {
            firstBox.offer(i);
        }
        input= Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> secondBox=new ArrayDeque<>();
        for (int i : input) {
            secondBox.push(i);
        }
        int totalSumValue=0;
        while (firstBox.size()!=0&&secondBox.size()!=0){
            int sum=firstBox.peek()+secondBox.peek();
            if (sum%2==0){
                totalSumValue+=sum;
                firstBox.remove();
                secondBox.pop();
            }else{
                firstBox.addLast(secondBox.peek());
                secondBox.remove();
            }
        }
        if (firstBox.size()==0){
            System.out.println("First magic box is empty.");
        }else if (secondBox.size()==0){
            System.out.println("Second magic box is empty.");
        }
        if (totalSumValue>=90){
            System.out.printf("Wow, your prey was epic! Value: %d",totalSumValue);
        }else{
            System.out.printf("Poor prey... Value: %d",totalSumValue);
        }
    }
}
