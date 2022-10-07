package IteratorsAndComparators_20_exc.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());
        TreeSet<Person> nameSet=new TreeSet<>(new NameComparator());
        TreeSet<Person> ageSet=new TreeSet<>(new AgeComparator());
        for (int i = 0; i <n ; i++) {
            String[] peopleData=scan.nextLine().split(" ");
            String name=peopleData[0];
            int age=Integer.parseInt(peopleData[1]);
            Person person=new Person(name,age);
            nameSet.add(person);
            ageSet.add(person);
        }
        for (Person person : nameSet) {
            System.out.println(person);
        }

        for (Person person : ageSet) {
            System.out.println(person);
        }

    }
}
