package StreamsFilesAndDirectories_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input= "/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/input.txt";
        String output="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/02.WriteToFileOutput.txt";
        try {
            FileInputStream fileInputStream=new FileInputStream(input);
            FileOutputStream fileOutputStream=new FileOutputStream(output);
            int read= fileInputStream.read();
            Set<Character> punctuation= Set.of(',','.','!','?');
            while (read!=-1){
                if (!punctuation.contains((char)read)){
                    fileOutputStream.write(read);

                }
                read= fileInputStream.read();
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found "+e.getMessage());
        }catch (IOException e){
            System.out.println("Can not read file");
        }

    }
}
