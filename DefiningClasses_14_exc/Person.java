package DefiningClasses_14_exc;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        if (age>30){
            this.name=name;
            this.age=age;
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return String.format("%s - %d",getName(),getAge());
    }
}
