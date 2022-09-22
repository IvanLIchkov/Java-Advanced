package SetsAndMapsAdvanced_7;

import java.util.*;

public class CitiesByContinentalCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> map=new LinkedHashMap<>();

        while (n-- >0){
            String[] data=scan.nextLine().split("\\s+");
            String continent=data[0];
            String country=data[1];
            String city=data[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countryWithCities=map.get(continent);
            countryWithCities.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countryWithCities.get(country);
            cities.add(city);
        }
        map.entrySet()
                .forEach(entry ->{
                    String continent = entry.getKey();
                    Map<String, List<String>> countryWithCities=entry.getValue();

                    System.out.println(continent+":");
                    countryWithCities.entrySet()
                            .forEach(e->{
                                System.out.println("  "+ e.getKey()+" -> "+String.join(", ",e.getValue()));
                            });
                });
    }
}
