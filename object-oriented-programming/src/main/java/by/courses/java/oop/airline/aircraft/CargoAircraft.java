package by.courses.java.oop.airline.aircraft;

public class CargoAircraft extends AbstractAircraft {
    private Integer cargoCompartmentVolume;
    private Integer capacity; //грузоподъемность

    public CargoAircraft(Integer range, Integer maximumSpeed, String model, String producer, Integer cargoCompartmentVolume, Integer capacity) {
        super(range, maximumSpeed, model, producer);
        this.cargoCompartmentVolume = cargoCompartmentVolume;
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "capacity = " + capacity +
                " t, cargo compartment volume = " + cargoCompartmentVolume +
                " m^3}";
    }

    public Integer getCargoCompartmentVolume() {
        return cargoCompartmentVolume;
    }
}
