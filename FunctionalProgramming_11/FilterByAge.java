package FunctionalProgramming_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public  static class Person{
        String name;
        int age;

        Person(String name, int age){
            this.name=name;
            this.age=age;
        }


    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people= IntStream.range(0, n)
                .mapToObj(i-> readParson(scan))
                .collect(Collectors.toList());//This is the same as while under it and doing same work with method
//        while (n-- > 0) {
//            String[] data= scan.nextLine().split(", ");
//            String name=data[0];
//            int age=Integer.parseInt(data[1]);
//            Person p=new Person(name, age);
//            people.add(p);
//        }
        String ageCondition= scan.nextLine();
        int ageFilter=Integer.parseInt(scan.nextLine());
        String outPutFormat= scan.nextLine();
        people = filteredByAgeCondition(people, getPredicate(ageCondition, ageFilter));

        Consumer<Person> printer=getPrinter(outPutFormat);
        people.forEach(printer);
    }

    private static Person readParson(Scanner scan) {
        String[] data= scan.nextLine().split(", ");
               String name=data[0];
               int age=Integer.parseInt(data[1]);
               return new Person(name, age);
    }

    private static Consumer<Person> getPrinter(String outPutFormat) {
        switch (outPutFormat){
            case "name":
                return p-> System.out.println(p.name);
            case "age":
                return p-> System.out.println(p.age);
            case "name age":
                return p-> System.out.println(p.name+" - "+p.age);
            default:
                throw new IllegalArgumentException("Unknow format "+outPutFormat);
        }
    }

    private static Predicate<Person> getPredicate(String ageCondition, int ageFilter) {
        switch (ageCondition){
            case "younger":
                return p->p.age<=ageFilter;
            case "older":
                return p-> p.age>=ageFilter;
            default:
                throw new IllegalArgumentException("Invalid parameters for age predicate "+ageCondition+" "+ageFilter);
        }
    }

    public static List<Person> filteredByAgeCondition(List<Person> people, Predicate<Person> predicate){
            return people.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
    }
}
