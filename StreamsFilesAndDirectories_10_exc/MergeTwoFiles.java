package StreamsFilesAndDirectories_10_exc;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) {
        try {
            Scanner firstFile=new Scanner(new FileReader("/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/inputOne.txt"));
            Scanner secondFile=new Scanner(new FileReader("/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/inputTwo.txt"));
            List<String> mergetFiles=new ArrayList<>();
            PrintWriter writer=new PrintWriter("StreamsFilesAndDirectories_10_exc/output5.txt");
            while (firstFile.hasNext()){
                mergetFiles.add(firstFile.next());
            }
            while (secondFile.hasNext()){
                mergetFiles.add(secondFile.next());
            }
            mergetFiles.stream().forEach(file->writer.write(file+"\n"));
            writer.close();

        } catch (IOException e){

        }
    }
}
