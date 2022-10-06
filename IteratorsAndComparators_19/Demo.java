package IteratorsAndComparators_19;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printObject("Hello", "world", "!");
        printObject("Hello", "world");
        printObject();
    }
    public static<T> void printObject(T... str){
        if (str.length==0){
            System.out.println("Please add input");
        }
        Arrays.stream(str).forEach(System.out::println);
    }
}
