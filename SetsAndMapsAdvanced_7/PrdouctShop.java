package SetsAndMapsAdvanced_7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PrdouctShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input=scan.nextLine().split(", ");
        Map<String, Map<String, Double>> shop=new TreeMap<>();
        while (!input[0].equals("Revision")){
            String shopName=input[0];
            String product=input[1];
            double  price=Double.parseDouble(input[2]);
            shop.putIfAbsent(shopName,new LinkedHashMap<>());
            Map<String, Double> productsAndPrice = shop.get(shopName);
            productsAndPrice.putIfAbsent(product, price);
            input=scan.nextLine().split(", ");
        }
        shop.entrySet()
                .forEach(entry->{
                    String shopName= entry.getKey();
                    Map<String,Double> productAndPrice=entry.getValue();
                    System.out.printf("%s->%n",shopName);
                    productAndPrice.entrySet()
                            .forEach(e->{
                                System.out.printf("Product: %s, Price: %.1f%n",e.getKey(),e.getValue());
                            });
                });
        System.out.println();
    }
}
