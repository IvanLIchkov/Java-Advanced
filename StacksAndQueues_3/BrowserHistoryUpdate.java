package StacksAndQueues_3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String commands= scan.nextLine();
        ArrayDeque<String> browserHistory=new ArrayDeque<>();
        ArrayDeque<String> forwardHistory=new ArrayDeque<>();

        while (!commands.equals("Home")){
            if (commands.equals("back")){
                if (browserHistory.size()<2){
                    System.out.println("no previous URLs");
                }else{
                    forwardHistory.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            }else if (commands.equals("forward")){
                if (forwardHistory.size()<1){
                    System.out.println("no next URLs");
                }else{
                    System.out.println(forwardHistory.peek());
                    browserHistory.push(forwardHistory.pop());
                }
            }else{
                System.out.println(commands);
                browserHistory.push(commands);
                forwardHistory.clear();
            }
            commands= scan.nextLine();
        }
    }
}
