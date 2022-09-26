package StreamsFilesAndDirectories_9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NestedFiles {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        File root= new File("/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/Files-and-Streams/Files-and-Streams");

        System.out.println(Files.walk(root.toPath())
                .map(Path::toFile)
                .map(File::getName)
                .collect(Collectors.joining(System.lineSeparator())));


    }
}
