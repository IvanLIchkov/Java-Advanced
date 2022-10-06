package IteratorsAndComparators_19;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printString("Hello", "world", "!");
        printString("Hello", "world");
        printString();
    }
    public static void printString(String... str){
        String[] strings=str;
        if (strings.length==0){
            System.out.println("Please add input");
        }
        Arrays.stream(strings).forEach(System.out::println);
    }
}
