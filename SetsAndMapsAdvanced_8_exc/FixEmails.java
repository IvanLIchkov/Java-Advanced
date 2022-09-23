package SetsAndMapsAdvanced_8_exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name= scan.nextLine();
        LinkedHashMap<String, String> nameAndEmail=new LinkedHashMap<>();
        while (!name.equals("stop")){
            String email= scan.nextLine();
            if (email.contains(".us")||email.contains(".uk")||email.contains(".com")){

            }else{
                nameAndEmail.putIfAbsent(name, email);
            }
            name= scan.nextLine();
        }
        for (Map.Entry<String, String> stringStringEntry : nameAndEmail.entrySet()) {
            System.out.printf("%s -> %s%n",stringStringEntry.getKey(),stringStringEntry.getValue());
        }

    }
}
