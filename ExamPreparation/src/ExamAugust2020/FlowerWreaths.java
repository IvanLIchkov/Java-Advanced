package ExamAugust2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] tokens= Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> lilies=new ArrayDeque<>();
        for (int token : tokens) {
            lilies.offer(token);
        }
        tokens=Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> roses=new ArrayDeque<>();
        for (int token : tokens) {
            roses.push(token);
        }
        int wreath=0;
        int flowersLeft=0;
        while (roses.size()!=0&&lilies.size()!=0){
            int craftSum=lilies.peek()+roses.peek();
            if (craftSum==15){
                lilies.remove();
                roses.pop();
                wreath++;
            }else if (craftSum>15){
                int numbersOfLilies=lilies.peek();
                lilies.remove();
                lilies.addFirst(numbersOfLilies-2);
            }else{
                flowersLeft+=craftSum;
                lilies.remove();
                roses.pop();
            }
        }
        wreath+=flowersLeft/15;
        if (wreath>=5){
            System.out.println("You made it, you are going to the competition with "+wreath+" wreaths!" );
        }else {
            System.out.println("You didn't make it, you need "+(5-wreath)+" wreaths more!");
        }
    }
}
