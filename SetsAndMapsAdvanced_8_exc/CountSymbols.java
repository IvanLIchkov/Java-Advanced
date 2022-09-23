package SetsAndMapsAdvanced_8_exc;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<Character, Integer> symbolsCount=new TreeMap<>();
        String input=scan.nextLine();
        for (int i = 0; i <input.length() ; i++) {
            char symbol=input.charAt(i);
            if (symbolsCount.containsKey(symbol)){
                symbolsCount.put(symbol,symbolsCount.get(symbol)+1);
            }else{
                symbolsCount.put(symbol, 1);
            }
        }
        symbolsCount.entrySet()
                .forEach(entry->{
                    System.out.printf("%s: %d time/s%n",entry.getKey(), entry.getValue());
                });
    }
}
