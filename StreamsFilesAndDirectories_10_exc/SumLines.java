package StreamsFilesAndDirectories_10_exc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/input.txt";
        try(BufferedReader reader= Files.newBufferedReader(Paths.get(input))) {
            String line = reader.readLine();
            while (line!=null){
                long sum=0;
                for (char c : line.toCharArray()) {
                    sum+=c;
                }
                System.out.println(sum);
                line=reader.readLine();

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
