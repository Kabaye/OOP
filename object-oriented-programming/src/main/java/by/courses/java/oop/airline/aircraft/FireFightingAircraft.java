package by.courses.java.oop.airline.aircraft;

//Самолет экстренных ситуаций (тушить пожары)
public class FireFightingAircraft extends CargoAircraft {
    private int integratedBoilersVolume; //объем встроенных баков с водой
    private boolean availabilityToHaveExternalBoiler;

    public FireFightingAircraft(Integer range, Integer maximumSpeed, String model, String producer, Integer cargoCompartmentVolume, Integer capacity, int integratedBoilersVolume, boolean availabilityToHaveExternalBoiler) {
        super(range, maximumSpeed, model, producer, cargoCompartmentVolume, capacity);
        this.integratedBoilersVolume = integratedBoilersVolume;
        this.availabilityToHaveExternalBoiler = availabilityToHaveExternalBoiler;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return str.substring(0, str.length() - 2) +
                ", volume of integrated boilers = " + integratedBoilersVolume +
                "m^3, available to have external boiler = " + availabilityToHaveExternalBoiler + "}";
    }
}
