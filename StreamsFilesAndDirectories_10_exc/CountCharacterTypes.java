package StreamsFilesAndDirectories_10_exc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountCharacterTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/input.txt";

        try {
            PrintWriter writer=new PrintWriter("StreamsFilesAndDirectories_10_exc/output2.txt");
            BufferedReader reader = Files.newBufferedReader(Paths.get(input));
            String line= reader.readLine();
            int sumVowels=0;
            int constants=0;
            int punctoation=0;
            while (line!=null){
                char[] arr=line.toCharArray();
                for (char c : arr) {
                    if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                        sumVowels++;
                        continue;
                    }else if (c=='!'||c==','||c=='.'||c=='?'){
                        punctoation++;
                        continue;
                    }else if (c==' '){
                        continue;
                    }
                    else {
                        constants++;
                    }
                }
                    line= reader.readLine();

            }
            System.out.printf("Vowels: %d%n" +
                    "Consonants: %d%n" +
                    "Punctuation: %d",sumVowels,constants,punctoation);
        }catch (IOException e){

        }
    }
}
