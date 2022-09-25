package SetsAndMapsAdvanced_8_exc;

import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input=scan.nextLine().split("\\|");
        LinkedHashMap<String, Integer> countryAndPopulation=new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String,Integer>> townAndPopulation=new LinkedHashMap<>();
        while (!input[0].equals("report")){
            String town=input[0];
            String country=input[1];
            int numberOfPeople=Integer.parseInt(input[2]);
            if (countryAndPopulation.containsKey(country)){
                countryAndPopulation.put(country,countryAndPopulation.get(country)+numberOfPeople);
            }else{
                countryAndPopulation.put(country,numberOfPeople);
            }
            if (!townAndPopulation.containsKey(country)){
                townAndPopulation.put(country,new LinkedHashMap<>());
                townAndPopulation.get(country).put(town,numberOfPeople);
            }else{
                townAndPopulation.get(country).put(town,numberOfPeople);
            }
            input=scan.nextLine().split("\\|");
        }
        LinkedHashMap<String , Integer>sortedCountryAndPopulation=new LinkedHashMap<>();
         countryAndPopulation.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEachOrdered(x-> sortedCountryAndPopulation.put(x.getKey(),x.getValue()));

        for (var entry : sortedCountryAndPopulation.entrySet()) {
            System.out.printf("%s (total population: %d)%n",entry.getKey(),entry.getValue());
            for (var e : townAndPopulation.entrySet()) {
                if (e.getKey().equals(entry.getKey())){
                    for (var entryTown : e.getValue().entrySet()) {
                        System.out.printf("=>%s: %d%n",entryTown.getKey(),entryTown.getValue());
                    }

                }

            }

        }

    }
}
