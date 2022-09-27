package StreamsFilesAndDirectories_10_exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class LineNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/inputLineNumbers.txt";
        try {
            BufferedReader reader= Files.newBufferedReader(Paths.get(input));
            String line= reader.readLine();
            PrintWriter writer=new PrintWriter("StreamsFilesAndDirectories_10_exc/output3.txt");
            int counter=1;
            while (line!=null){
                String newLine=counter+". "+line;
                writer.write(newLine);
                writer.println();
                line= reader.readLine();
                counter++;
            }
            writer.close();
            reader.close();
        }catch (IOException e){

        }
    }
}
