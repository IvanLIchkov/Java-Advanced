package StreamsFilesAndDirectories_9;

import java.io.*;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) {
        String input= "/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/input.txt";
       String output="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/03.CopyBytesOutput.txt";
        try {
            FileInputStream fileInputStream=new FileInputStream(input);
            FileOutputStream fileOutputStream=new FileOutputStream(output);
            int read= fileInputStream.read();

            PrintWriter writer=new PrintWriter(fileOutputStream);
            while (read!=-1){
                if (read==' '){
                    writer.print(" ");
                }else if (read==10){
                    writer.println();
                }else {
                    writer.print(read);
                }
                read= fileInputStream.read();
            }
            writer.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found "+e.getMessage());
        }catch (IOException e){
            System.out.println("Can not read file");
        }
    }
}
