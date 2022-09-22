package SetsAndMapsAdvanced_7;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class DemoSets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashSet<Integer> hashSet=new HashSet<>();//TODO doesn't order in some way.
        hashSet.add(73);
        hashSet.add(13);
        hashSet.add(69);
        hashSet.add(42);
        System.out.println("Hash set elements");
        for (Integer element : hashSet) {
            System.out.println(element);
        }
        System.out.println();

        TreeSet<Integer> treeSet=new TreeSet<>();//TODO print elements in ascending order.
        treeSet.add(73);
        treeSet.add(13);
        treeSet.add(69);
        treeSet.add(42);
        System.out.println("Tree set elements");
        for (Integer element : treeSet) {
            System.out.println(element);
        }
        System.out.println();

        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>(); //TODO print elements in the same order as we enter them.
        linkedHashSet.add(73);
        linkedHashSet.add(13);
        linkedHashSet.add(69);
        linkedHashSet.add(42);
        System.out.println("Linked hash set elements");
        for (Integer element : linkedHashSet) {
            System.out.println(element);
        }

    }
}
