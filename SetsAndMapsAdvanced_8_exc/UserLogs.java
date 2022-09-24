package javaAdvanced.setsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> nameToIpToCount = new TreeMap<>();

        String line = "";
        while (!(line = reader.readLine()).equals("end")) {
            String ip = line.substring(line.indexOf("=") + 1, line.indexOf(" "));
            String user = line.substring(line.lastIndexOf("=") + 1);

            nameToIpToCount.putIfAbsent(user, new LinkedHashMap<>());

            Map<String, Integer> ipToCountInternMap = nameToIpToCount.get(user);
            ipToCountInternMap.putIfAbsent(ip, 0);
            ipToCountInternMap.put(ip, ipToCountInternMap.get(ip) + 1);
        }

        nameToIpToCount.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");

                    int count = 0;
                    Map<String, Integer> value = e.getValue();

                    for (Map.Entry<String, Integer> secondMap : value.entrySet()) {

                        String format =
                                (count++ == value.size() - 1)
                                        ? "%s => %d.%n"
                                        : "%s => %d, ";

                        System.out.printf(format, secondMap.getKey(), secondMap.getValue());
                    }


                });


    }
}