package SetsAndMapsAdvanced_8_exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> logs=new LinkedHashMap<>();
        String input= scan.nextLine();
        while (!input.equals("end")){
            String[] arr=input.split(" ");
            String ip=arr[0].substring(3);
            String user=arr[2].substring(5);
            logs.putIfAbsent(user, new LinkedHashMap<>());
            for (var entry : logs.entrySet()) {
                LinkedHashMap<String, Integer> ipAndLogs = entry.getValue();
                if (ipAndLogs.containsKey(ip)) {
                    ipAndLogs.put(ip, ipAndLogs.get(ip) + 1);
                }else{
                    ipAndLogs.put(ip, 1);
                }
            }

            input= scan.nextLine();
        }
        for (var log : logs.entrySet()) {
            System.out.printf("%s:%n",log.getKey());
        LinkedHashMap<String, Integer> attacks=log.getValue();
        StringBuilder sb=new StringBuilder();
            for (var singleIpAttack : attacks.entrySet()){
                String formattedAttack=String.format("%s => %d, ",singleIpAttack.getKey(), singleIpAttack.getValue());
                sb.append(formattedAttack);
            }
            String finalOutput= sb.substring(0,sb.length()-2);
            finalOutput=finalOutput+".";
            System.out.println(finalOutput);
        }
    }
}
