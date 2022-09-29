package FunctionalProgramming_12_exc;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> people = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
       List<String> commandLines=new ArrayList<>();
        String input= scan.nextLine();
        while (!input.equals("Print")){
            String[] inputAsArr=input.split(";");
            String command=inputAsArr[0];
            String filterType=inputAsArr[1];
            String filterParameter=inputAsArr[2];
            if (command.equals("Add filter")){
                commandLines.add(input);
            }else if (command.equals("Remove filter")){
                String commandToRemove="Add filter;"+filterType+";"+filterParameter;
                commandLines.removeIf(s->s.equals(commandToRemove));
            }
            input= scan.nextLine();
        }
        for (String commandLine : commandLines) {
            String[] inputAsArr=commandLine.split(";");
            String command=inputAsArr[0];
            Predicate<String> predicate=getPredicate(inputAsArr);
            switch (command){
                case "Add filter":
                    people.removeIf(predicate);
                    break;
            }
        }
        people.stream().forEach(person-> System.out.print(person+" "));
    }
    public static Predicate<String> getPredicate(String[] commands){
        Predicate<String> predicate=null;
        String filterType=commands[1];
        String filterParameter=commands[2];
        switch (filterType){
            case "Starts with":
                predicate=name->name.startsWith(filterParameter);
                break;
            case "Ends with":
                predicate=name->name.endsWith(filterParameter);
                break;
            case "Length":
                predicate=name->name.length()==Integer.parseInt(filterParameter);
                break;
            case "Contains":
                predicate=name->name.contains(filterParameter);
                break;
        }
        return predicate;
    }
}
