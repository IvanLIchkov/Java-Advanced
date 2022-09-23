package SetsAndMapsAdvanced_8_exc;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<String> uniqueWords=new LinkedHashSet<>();
        int n=Integer.parseInt(scan.nextLine());
        for (int i = 0; i <n ; i++) {
            String word =scan.nextLine();
            uniqueWords.add(word);
        }
        for (String uniqueWord : uniqueWords) {
            System.out.println(uniqueWord);
        }

    }
}
