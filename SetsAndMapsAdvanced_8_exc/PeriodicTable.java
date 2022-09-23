package SetsAndMapsAdvanced_8_exc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());
        TreeSet<String> periodicTable=new TreeSet<>();
        for (int i = 0; i <n ; i++) {
            String[] elements=scan.nextLine().split(" ");
            periodicTable.addAll(Arrays.asList(elements));
        }
        for (String s : periodicTable) {
            System.out.printf("%s ",s);
        }

    }
}
