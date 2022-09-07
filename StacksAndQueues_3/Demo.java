package StacksAndQueues_3;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{73, 42, 69, 13};

        Scanner scan = new Scanner(System.in);
        int element = Integer.parseInt(scan.nextLine());

        int index = -1;

        //Constant operation O(1)   -> true for HashMap<>
        //           arr[2]
        //           arr[1_000] both operations run for the same time

        //O(log(n))
        //  TreeMap<>
        //  BinarySearch -> разделя елементите на две части домато не намери нашия елемент


        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==element){
                index = i;
                break;
            }
        }
        int memoryInUse = Integer.BYTES * arr.length;//How much memory our algorithm is using
        System.out.println("You use "+memoryInUse+" BYTES");

        System.out.println(index);
    }
}
