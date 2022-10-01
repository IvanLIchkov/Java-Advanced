package DefiningClasses_14_exc.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> childrens;
    private Car car;

    public Person(String name, Company company, List<Pokemon> pokemons, List<Parent> parents, List<Children> childrens, Car car) {
        this.name = name;
        this.company = company;
        this.pokemons = pokemons;
        this.parents = parents;
        this.childrens = childrens;
        this.car = car;
    }
    public Person(String name){
        this(name,null,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Children> childrens) {
        this.childrens = childrens;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public static boolean isNull(String check){
        if (check==null){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
         String output = String.format("%s%n",getName());
                output+="Company:\n";
         try {
             company.getCompanyName();
             output+= String.format("%s %s %.2f%nCar:%n",getCompany().getCompanyName(),getCompany().getDepartment(),getCompany().getSalary());
         }catch (NullPointerException e){
             output+=String.format("Car:%n");
         }
         try {
             car.getModel();
             output+=String.format("%s %s%nPokemon:%n",car.getModel(),car.getSpeed());
         }catch (NullPointerException e){
             output+="Pokemon:\n";

        }if (!pokemons.isEmpty()){
            for (Pokemon pokemon : pokemons) {
                output+=String.format("%s %s%n",pokemon.getName(),pokemon.getPokemonType());
            }

        } output+="Parents:\n";
         if (!parents.isEmpty()){
            for (Parent parent : parents) {
                output+=String.format("%s %s%n",parent.getParentName(),parent.getParentBirthday());
            }
         }output+="Children:\n";
         if (!childrens.isEmpty()){
            for (Children children : childrens) {
                output+=String.format("%s %s%n",children.getChildName(),children.getChildBirthday());
            }

        }
         return output;
    }
}
