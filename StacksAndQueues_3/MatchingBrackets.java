package StacksAndQueues_3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();

        ArrayDeque<Integer> openIndexes=new ArrayDeque<>();

        for (int i = 0; i <expression.length() ; i++) {
            char currentSymbol = expression.charAt(i);

            if (currentSymbol == '('){
                openIndexes.push(i);
            }else if (currentSymbol == ')'){
                int lastOpenIndex = openIndexes.pop();
                String matching = expression.substring(lastOpenIndex, i+1);
                System.out.println(matching);
            }
        }
    }
}
