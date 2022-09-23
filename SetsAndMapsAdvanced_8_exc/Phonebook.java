package SetsAndMapsAdvanced_8_exc;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input=scan.nextLine().split("-");
        LinkedHashMap<String, String > phoneBook=new LinkedHashMap<>();
        while (!input[0].equals("search")){
            String name=input[0];
            String number=input[1];
            if (phoneBook.containsKey(name)){
                phoneBook.put(name,number);
            }else {
                phoneBook.put(name, number);
            }
            input=scan.nextLine().split("-");
        }
        String checkName=scan.nextLine();
        while (!checkName.equals("stop")){
            if (phoneBook.containsKey(checkName)){
                System.out.println(checkName+" -> "+phoneBook.get(checkName));
            }else{
                System.out.println("Contact "+checkName+" does not exist.");
            }
            checkName= scan.nextLine();
        }
    }
}
