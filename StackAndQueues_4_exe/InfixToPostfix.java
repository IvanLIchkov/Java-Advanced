package StackAndQueues_4_exe;

import java.util.*;
import java.util.stream.Collectors;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPlants=Integer.parseInt(scan.nextLine());
        List<Integer> pesticide = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int daysCounter=0;
        boolean dead=false;
        while (!dead){
            for (int i = 0; i <pesticide.size()-1 ; i++) {
                if (pesticide.get(i)< pesticide.get(i+1)){
                    dead=false;
                    break;
                }else{
                    dead=true;
                }
            }
            if (dead){
                System.out.println(daysCounter);
                return;
            }
            boolean isInEnd=false;
            int i =1;
            boolean noKill=false;
            ArrayList<Integer> positionsOfDeadPlants=new ArrayList<>();
            while (!isInEnd){
                if (i>=pesticide.size()){
                    isInEnd=true;
                    continue;
                }
                if (pesticide.get(i-1)< pesticide.get(i)) {
                    positionsOfDeadPlants.add(pesticide.get(i));
                    noKill=true;
                }
                i++;
            }
            for (int j = positionsOfDeadPlants.size()-1; j >=0 ; j--) {
                pesticide.remove(positionsOfDeadPlants.get(j));
            }
            if (noKill){
                daysCounter++;
            }
        }
    }
}
