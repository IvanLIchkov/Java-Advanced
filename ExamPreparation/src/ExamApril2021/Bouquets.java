package ExamApril2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input= Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> tulips=new ArrayDeque<>();
        for (int i : input) {
            tulips.push(i);
        }
        input= Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> daffodils=new ArrayDeque<>();
        for (int i : input) {
            daffodils.offer(i);
        }
        int storedFlowers=0;
        int bouquets=0;
        while (tulips.size()!=0&&daffodils.size()!=0){
            int sum=tulips.peek()+daffodils.peek();
            if (sum==15){
                bouquets++;
                tulips.remove();
                daffodils.pop();
            }else if (sum>15){
                int newTulips=tulips.peek()-2;
                tulips.remove();
                tulips.addLast(newTulips);
            }else {
                storedFlowers+=sum;
                tulips.remove();
                daffodils.pop();
            }
        }
        bouquets+=storedFlowers/15;
        if (bouquets>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquets);
        }else{
            System.out.printf("You failed... You need more %d bouquets.",5-bouquets);
        }

    }
}
