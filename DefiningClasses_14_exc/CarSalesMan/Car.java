package DefiningClasses_14_exc.CarSalesMan;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        String output = String.format("%s:%n" +
                "%s:%n" +
                "Power: %s%n", getModel(), getEngine().getModel(), getEngine().getPower());
        if (getEngine().getDisplacement()==-1){
            output+="Displacement: n/a\n";
        }else{
            output+= "Displacement: "+getEngine().getDisplacement()+"\n";
        }
        output+="Efficiency: "+getEngine().getEfficiency()+"\n";
        if (getWeight()==-1){
            output+="Weight: n/a\n";
        }else{
            output+= "Weight: "+getWeight()+"\n";
        }
       output+="Color: "+getColor();
        return output;
    }
}
