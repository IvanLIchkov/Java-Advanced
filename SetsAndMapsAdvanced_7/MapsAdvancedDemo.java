package SetsAndMapsAdvanced_7;

import java.util.*;

public class MapsAdvancedDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, String>map=new HashMap<>();
        //3 ways to iterate a map

        Set<Integer> integers = map.keySet(); //TODO Iterate the keys

        Set<Map.Entry<Integer, String>> entries = map.entrySet();//TODO Iterate keys and values

        Collection<String> values = map.values();//Iterate values (don't use unless needed)
    }
}
