package StreamsFilesAndDirectories_9;

import jdk.dynalink.StandardOperation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String input= "/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/input.txt";
        String output="/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/06.SortLinesOutput.txt";

        List<String> sortedLines = Files.readAllLines(Paths.get(input))
                .stream()
                .sorted()
                .collect(Collectors.toList());
        Files.write(Path.of(output),sortedLines, StandardOpenOption.WRITE);
    }
}
