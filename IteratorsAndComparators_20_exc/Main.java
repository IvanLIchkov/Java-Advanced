package IteratorsAndComparators_20_exc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        ListyIterator listyIterator = null;
        while (!line.equals("END")) {
            String[] commandparts = line.split("\\s+");
            String commandName = commandparts[0];
            switch (commandName) {
                case "Create":
                    if (commandparts.length > 1) {
                        listyIterator = new ListyIterator(Arrays.copyOfRange(commandparts, 1, commandparts.length));
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    for (String element : listyIterator) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                    break;

            }
            line = scan.nextLine();
        }

    }
}
