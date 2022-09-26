package StreamsFilesAndDirectories_9;

import java.io.File;
import java.util.Arrays;

public class ListFiles {
    public static void main(String[] args) {
        String input= "/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/Files-and-Streams";

        File root= new File("/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/Files-and-Streams");

        Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .forEach(f-> System.out.println("["+f.getName()+"]: "+f.length()));
    }
}
