package StackAndQueues_4_exe;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());
        if (n==0){
            System.out.println(0);
            return;
        }
        fibonacci(1,1,n);
    }

    private static void fibonacci(int x, int y,int n) {
        n--;
        if (n==0){
            System.out.println(y);
            return;
        }
        int momentNumber=y;
        y=x+y;
        x=momentNumber;
        fibonacci(x,y,n);
    }
}
