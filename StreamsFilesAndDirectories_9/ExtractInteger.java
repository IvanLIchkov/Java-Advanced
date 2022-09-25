package StreamsFilesAndDirectories_9;

import java.io.*;
import java.util.Scanner;

public class ExtractInteger {
    public static void main(String[] args) throws FileNotFoundException {
        String input= "/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/input.txt";
        String output="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/04.ExtractIntegersOutput.txt";

        FileInputStream fileInputStream=new FileInputStream(input);
        Scanner scan = new Scanner(fileInputStream);
        PrintWriter writer=new PrintWriter(output);

        while (scan.hasNext()){
            if (scan.hasNextInt()){
                writer.println(scan.next());
            }else {
                scan.next();
            }
        }
        writer.close();
    }
}
