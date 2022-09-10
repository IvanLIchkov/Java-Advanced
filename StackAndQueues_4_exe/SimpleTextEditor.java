package StackAndQueues_4_exe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbersOfOperations=Integer.parseInt(scan.nextLine());
        ArrayDeque<String> historyQueue=new ArrayDeque<>();
        StringBuilder text=new StringBuilder();
        for (int i = 0; i <numbersOfOperations ; i++) {
            String[] commands=scan.nextLine().split("\\s+");
            switch (commands[0]){
                case "1":
                    historyQueue.push(String.valueOf(text));
                    text.append(commands[1]);
                    break;
                case "2":
                    historyQueue.push(String.valueOf(text));
                    int count=Integer.parseInt(commands[1]);
                    text.delete(text.length()-count,text.length());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(commands[1])-1));
                    break;
                case "4":
//                    if (historyQueue.isEmpty()){
//                        break;
//                    }
                    text= new StringBuilder(historyQueue.pop());
                    break;
            }
        }
    }
}

