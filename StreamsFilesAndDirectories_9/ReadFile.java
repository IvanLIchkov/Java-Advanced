package StreamsFilesAndDirectories_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input= scan.nextLine();

        try {
            FileInputStream fileInputStream=new FileInputStream(input);
            int bytte= fileInputStream.read();
            while (bytte>=0){
                System.out.printf("%s ",Integer.toBinaryString(bytte));
                bytte= fileInputStream.read();
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found "+e.getMessage());
        }catch (IOException e){
            System.out.println("Can not read file");
        }

    }
}
