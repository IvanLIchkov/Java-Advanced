package Generics_18_exc.Box1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());

        Box1 box=new Box1();

        for (int i = 0; i < n; i++) {
            String element= scan.nextLine();
            box.add(element);
        }
        System.out.println(box);
    }
}
