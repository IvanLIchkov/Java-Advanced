package DefiningClasses_14_exc.PokemonTrainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input= scan.nextLine();
        List<Trainer> trainers=new ArrayList<>();
        while (!input.equals("Tournament")){
            String[] tokens=input.split("\\s+");
            String trainerName=tokens[0];
            String pokemonName=tokens[1];
            String element=tokens[2];
            int health=Integer.parseInt(tokens[3]);
            if (trainers.stream().anyMatch(e->e.getName().equals(trainerName))){
                trainers.stream()
                        .map(e->{
                            if (e.getName().equals(trainerName)){
                                List<Pokemon> pokemons = e.getPokemons();
                                pokemons.add(new Pokemon(pokemonName,element,health));
                                e.setPokemons(pokemons);
                            }
                            return e;
                        })
                        .collect(Collectors.toList());
            }else{
                trainers.add(new Trainer(trainerName,0,new ArrayList<>()));
                trainers.stream()
                        .map(e->{
                            if (e.getName().equals(trainerName)){
                                List<Pokemon> pokemons = e.getPokemons();
                                pokemons.add(new Pokemon(pokemonName,element,health));
                                e.setPokemons(pokemons);
                            }
                            return e;
                        }).collect(Collectors.toList());
            }
            input= scan.nextLine();
        }
        String input1= scan.nextLine();
        while (!input1.equals("End")){
            String finalInput = input1;
            trainers.stream().map(e->{
                if (e.checkForElement(finalInput)){
                    e.setNumberOfBadges(e.getNumberOfBadges()+1);
                } else {
                    e.minusHealth();
                }
                return e;
            }).collect(Collectors.toList());
            input1= scan.nextLine();
        }
        trainers.stream().sorted((e1,e2)->Integer.compare(e2.getNumberOfBadges(), e1.getNumberOfBadges()))
                        .forEach(e-> System.out.println(e.toString()));

    }
}
