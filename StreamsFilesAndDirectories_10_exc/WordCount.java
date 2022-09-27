package StreamsFilesAndDirectories_10_exc;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        String input="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/words.txt";
        String secondFilePath="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/text.txt";
        try {
          Scanner scan=new Scanner(new FileReader("/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_10_exc/words.txt"));
            Scanner textScanner=new Scanner(new FileReader(secondFilePath));
            PrintWriter printWriter=new PrintWriter("StreamsFilesAndDirectories_10_exc/output4.txt");
            LinkedHashMap<String, Integer> wordMap=new LinkedHashMap<>();
            Arrays.stream(scan.nextLine().split(" "))
                    .forEach(word->wordMap.put(word,0));
            while (textScanner.hasNext()){
                String textInput=textScanner.next();
                if (wordMap.containsKey(textInput)){
                    int occurences=wordMap.get(textInput);
                    occurences++;
                    wordMap.put(textInput, occurences);
                }
            }
            wordMap.entrySet().forEach(entry-> printWriter.printf("%s - %d%n",entry.getKey(),entry.getValue()));
            printWriter.close();
        }catch (IOException e){

        }

    }
}
