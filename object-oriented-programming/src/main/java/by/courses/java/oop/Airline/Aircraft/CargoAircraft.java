package by.courses.java.oop.Airline.Aircraft;

public class CargoAircraft extends AbstractAircraft {
    private Integer cargoCompartmentVolume;

    public CargoAircraft(Integer range, Integer capacity, Integer maximumSpeed, String name, Float fuselageWidth, Integer length, Integer cargoCompartmentVolume) {
        super(range, capacity, maximumSpeed, name, fuselageWidth, length);
        this.cargoCompartmentVolume = cargoCompartmentVolume;
    }

    @Override
    public String toString() {
        return super.toString() +
                " cargoCompartmentVolume = " + cargoCompartmentVolume +
                "m^3}";
    }

    public Integer getCargoCompartmentVolume() {
        return cargoCompartmentVolume;
    }
}
