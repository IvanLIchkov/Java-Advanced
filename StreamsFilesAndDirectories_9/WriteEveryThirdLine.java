package StreamsFilesAndDirectories_9;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String input = "/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/input.txt";
        String output = "/Users/scopi/Desktop/Java-Advanced/StreamsFilesAndDirectories_9/05.WriteEveryThirdLineOutput.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        BufferedWriter writer=new BufferedWriter(new FileWriter(output));

        String line = reader.readLine();
        int counter=0;
        while (line!=null){
            counter++;
            if (counter%3==0){
                writer.write(line);
                writer.newLine();
            }
            line=reader.readLine();
        }
        reader.close();
        writer.close();
    }
}
