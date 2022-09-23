package SetsAndMapsAdvanced_8_exc;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N=Integer.parseInt(scan.next());
        int M=Integer.parseInt(scan.next());
        scan.nextLine();
        LinkedHashSet<Integer> NSet=new LinkedHashSet<>();
        for (int i = 0; i <N ; i++) {
            int number=Integer.parseInt(scan.nextLine());
            NSet.add(number);
        }
        LinkedHashSet<Integer> Mset=new LinkedHashSet<>();
        for (int i = 0; i <M ; i++) {
            int number=Integer.parseInt(scan.nextLine());
            Mset.add(number);
        }
        for (Integer element : NSet) {
            if (Mset.contains(element)){
                System.out.print(element+" ");
            }
        }

    }
}
