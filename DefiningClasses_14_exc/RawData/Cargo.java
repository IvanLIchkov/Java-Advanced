package DefiningClasses_14_exc.RawData;

public class Cargo {
    private int CargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        CargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }
}
