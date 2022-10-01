package DefiningClasses_14_exc.CarSalesMan;

public class Engine {
    private String model;
    private String power;
    private int displacement;
    private String efficiency;

    public Engine(String model, String power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public Engine(String model, String power) {
        this(model, power, -1, "n/a");
    }

    public Engine(String model, String power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, String power, String efficiency) {
        this(model, power, -1, efficiency);
    }
}
