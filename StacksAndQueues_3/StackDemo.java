package StacksAndQueues_3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack =  new ArrayDeque<>();

        stack.push(13);
        stack.push(42);
        stack.push(69);
        stack.push(73);// Чрез stack.push() се добавят елементи в стака
        //Add -> push(e),
        //Remove Top -> pop(),
        //look at top -> peek()

        //stack.removeAll(Arrays.asList(69));TODO така се премахват всички срещнати но трябва да се придаде като лист, доакто stack.remove(69) трие само първият срещнат елемент с тази стойност.

        int element = 123;

//        stack.contains(element); //TODO има много различни операции в стека
//        stack.remove(element);

//        while (!stack.isEmpty()){
//            int topElement = stack.pop();
//            System.out.println(topElement);
//        }

//        int topElement = stack.pop();//TODO Това е командата за премахване  на елемента на върха
//        System.out.println(topElement);
//        topElement = stack.pop();
//
//        System.out.println(topElement);
//        topElement = stack.pop();
//
//        System.out.println(topElement);
//        topElement = stack.pop();
//
//        System.out.println(topElement);


    }
}
