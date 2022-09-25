package StreamsFilesAndDirectories_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StreamsDemo {
    public static void main(String[] args){

        String path="/Users/scopi/Desktop/Java advanced resources Folder/04.Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            System.out.println("File was found it's ok");
            int bytte=fileInputStream.read();
            while (bytte!=-1){
                System.out.print((char)(bytte));
                bytte=fileInputStream.read();
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found "+e.getMessage());
        }catch (IOException e){
            System.out.println("Cannot read from file");
        }
//        Scanner scan = new Scanner(fileInputStream);
//        String line= scan.nextLine();
//        while (scan.hasNextLine()){
//            System.out.println(line);
//            line= scan.nextLine();
//        }                           //This is one of the ways to read files with scanner from directory.

//        int bytte=fileInputStream.read();
//        while (bytte!=-1){
//            System.out.print((char)(bytte));
//            bytte=fileInputStream.read();
//        }                                   //This is the way of reading files as bytes and casting them to chars.


    }
}
