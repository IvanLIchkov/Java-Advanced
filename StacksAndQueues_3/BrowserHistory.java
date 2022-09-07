package StacksAndQueues_3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String>history = new ArrayDeque<>();
        String nextNavigation= scan.nextLine();
        while (!nextNavigation.equals("Home")){
            if (nextNavigation.equals("back")){
                if (history.size()<=1){
                    System.out.println("no previous URLs");
                }else{
                    history.pop();
                    System.out.println(history.peek());
                }
            }else {
                history.push(nextNavigation);
                System.out.println(history.peek());
            }
            nextNavigation= scan.nextLine();
        }
    }
}
