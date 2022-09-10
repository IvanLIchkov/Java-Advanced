package StackAndQueues_4_exe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbersOfOperations=Integer.parseInt(scan.nextLine());
        ArrayDeque<String> historyStack=new ArrayDeque<>();
        StringBuilder text=new StringBuilder();
        for (int i = 0; i <numbersOfOperations ; i++) {
            String[] commands=scan.nextLine().split("\\s+");
            switch (commands[0]){
                case "1":
                    text.append(commands[1]);
                    historyStack.push(String.valueOf(text));
                    break;
                case "2":
                    int count=Integer.parseInt(commands[1]);
                    text.delete(text.length()-count,text.length());
                    historyStack.push(String.valueOf(text));
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(commands[1])-1));
                    break;
                case "4":
                    if (historyStack.isEmpty()){
                        break;
                    }
                    historyStack.poll();
                    text= new StringBuilder(historyStack.peek());
                    break;
            }
        }
    }
}
