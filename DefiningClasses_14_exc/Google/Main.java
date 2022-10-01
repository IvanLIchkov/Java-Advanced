package DefiningClasses_14_exc.Google;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static boolean containsName(List<Person> people, String name){
        return people.stream().map(Person::getName).anyMatch(name::equals);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input=scan.nextLine();
        List<Person> people=new ArrayList<>();
        while (!input.equals("End")){
        String[] tokens=input.split("\\s+");
        String name=tokens[0];
        String classType=tokens[1];
        if (!containsName(people,name)){
            people.add(new Person(name));
        }
        switch (classType){
            case "company":
                String companyName=tokens[2];
                String department=tokens[3];
                double salary=Double.parseDouble(tokens[4]);
                people.stream().map(p->{
                    if (p.getName().equals(name)) {
                        p.setCompany(new Company(companyName,department,salary));
                    }
                    return p;
                }).collect(Collectors.toList());
                break;
            case "pokemon":
                String pokemonName=tokens[2];
                String pokemonType=tokens[3];
                people.stream().map(p->{
                    if (p.getName().equals(name)) {
                        List<Pokemon> pokemons = p.getPokemons();
                        pokemons.add(new Pokemon(pokemonName,pokemonType));
                    }
                    return p;
                }).collect(Collectors.toList());
                break;
            case "parents":
                String parentName=tokens[2];
                String parentBirthday=tokens[3];
                people.stream().map(p->{
                    if (p.getName().equals(name)) {
                        List<Parent> parents = p.getParents();
                        parents.add(new Parent(parentName,parentBirthday));
                    }
                    return p;
                }).collect(Collectors.toList());
                break;
            case "children":
                String childrenName=tokens[2];
                String childrenBirthday=tokens[3];
                people.stream().map(p->{
                    if (p.getName().equals(name)) {
                        List<Children> childrens = p.getChildrens();
                        childrens.add(new Children(childrenName,childrenBirthday));
                    }
                    return p;
                }).collect(Collectors.toList());
                break;
            case "car":
                String model=tokens[2];
                String speed=tokens[3];
                people.stream().map(p->{
                    if (p.getName().equals(name)) {
                        p.setCar(new Car(model,speed));
                    }
                    return p;
                }).collect(Collectors.toList());
                break;
        }
        input= scan.nextLine();
        }
        String outputName= scan.nextLine();
        for (Person person : people) {
            if (person.getName().equals(outputName)){
                System.out.println(person.toString());
            }
        }

    }
}
