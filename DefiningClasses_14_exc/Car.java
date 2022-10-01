package DefiningClasses_14_exc;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumption;
    private  int distance;

    public Car(String model, double fuelAmount, double fuelConsumption){
        this.model=model;
        this.fuelAmount=fuelAmount;
        this.fuelConsumption=fuelConsumption;
        this.distance=0;
    }
    public boolean canCarMoveDistance(int km){
        if (this.fuelConsumption*km<=this.fuelAmount){
            return true;
        }
        return false;
    }
    public void changeKm(int distance){
        setDistance(getDistance() + distance);
        setFuelAmount(getFuelAmount()-fuelConsumption*distance);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {

        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {

        this.fuelAmount = fuelAmount;
    }

    public double getFuelConsumption() {

        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {

        this.fuelConsumption = fuelConsumption;
    }

    public int getDistance() {

        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString(){
         return String.format("%s %.2f %d",getModel(),getFuelAmount(),getDistance());
    }
}
