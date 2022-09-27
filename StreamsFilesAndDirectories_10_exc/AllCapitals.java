package StreamsFilesAndDirectories_10_exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AllCapitals {
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                String input="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/input.txt";
                try{
                        BufferedReader reader= Files.newBufferedReader(Paths.get(input));
                        String line= reader.readLine();
                        PrintWriter writer=new PrintWriter("StreamsFilesAndDirectories_10_exc/output.txt");
                        while (line!=null){
                                line= line.toUpperCase();
                                writer.write(line);
                                writer.println();
                                line= reader.readLine();
                        }
                        writer.close();

                }catch (IOException e){

                }
        }
}
