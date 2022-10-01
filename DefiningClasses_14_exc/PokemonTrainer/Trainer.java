package DefiningClasses_14_exc.PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemons = pokemons;
    }
    public void minusHealth(){
        pokemons.forEach(e->e.setHealth(e.getHealth()-10));
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);

    }
    public boolean checkForElement(String element){
       return pokemons.stream().anyMatch(e->e.getElement().equals(element));
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return String.format("%s %d %d",getName(),getNumberOfBadges(),getPokemons().size());
    }
}
