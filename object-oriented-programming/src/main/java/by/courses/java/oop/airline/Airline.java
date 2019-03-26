package by.courses.java.oop.airline;

import by.courses.java.oop.airline.aircraft.AbstractAircraft;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private List<AbstractAircraft> fleet;
    private String nameOfCompany;
    private String locationCountry;

    public Airline(String nameOfCompany, String locationCountry) {
        this.nameOfCompany = nameOfCompany;
        this.locationCountry = locationCountry;
        fleet = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "airline {" +
                "name of company = '" + nameOfCompany + '\'' +
                ", location country = '" + locationCountry + '\'' +
                ", capacity of fleet = " + fleet.size() +
                " units}";
    }

    public List<AbstractAircraft> getAirFleet() {
        return fleet;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public boolean addPlaneToPark(AbstractAircraft aircraft) {
        if (aircraft != null) {
            fleet.add(aircraft);
            return true;
        }
        return false;
    }
}
