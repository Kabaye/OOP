package by.courses.java.oop.Airline.Aircraft;

public class CargoAircraft extends AbstractAircraft {
    private Integer cargoCompartmentVolume;

    public CargoAircraft(Integer range, Integer capacity, Integer maximumSpeed, String model, String producer, Integer cargoCompartmentVolume) {
        super(range, capacity, maximumSpeed, model, producer);
        this.cargoCompartmentVolume = cargoCompartmentVolume;
    }

    @Override
    public String toString() {
        return super.toString() +
                " cargo compartment volume = " + cargoCompartmentVolume +
                " m^3}";
    }

    public Integer getCargoCompartmentVolume() {
        return cargoCompartmentVolume;
    }
}
