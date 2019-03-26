package by.courses.java.oop.airline.aircraft;

//Самолет экстренных ситуаций (тушить пожары)
public class FireFightingAircraft extends AbstractAircraft {
    private int integratedBoilersVolume; //объем встроенных баков с водой
    private boolean availabilityToHaveExternalBoiler;

    public FireFightingAircraft(Integer range, Integer maximumSpeed, String model, String producer, int integratedBoilersVolume, boolean availabilityToHaveExternalBoiler) {
        super(range, maximumSpeed, model, producer);
        this.integratedBoilersVolume = integratedBoilersVolume;
        this.availabilityToHaveExternalBoiler = availabilityToHaveExternalBoiler;
    }

    @Override
    public String toString() {
        return super.toString() +
                "volume of integrated boilers = " + integratedBoilersVolume +
                "m^3, available to have external boiler = " + availabilityToHaveExternalBoiler + "}";
    }
}
