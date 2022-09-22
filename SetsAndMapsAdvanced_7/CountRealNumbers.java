package SetsAndMapsAdvanced_7;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double, Integer> map=new LinkedHashMap<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(key ->{

                    if (map.containsKey(key)){
                        int oldCount=map.get(key);
                        int newCount= oldCount+1;
                        map.put(key, newCount);
                    }else{
                        map.put(key, 1);
                    }
                });
        for (var entry : map.entrySet()) {
            System.out.println(String.format("%.1f -> %d",entry.getKey(),entry.getValue()));
        }
    }
}
