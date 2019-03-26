package by.courses.java.oop.Airline;

import by.courses.java.oop.Airline.Aircraft.AbstractAircraft;

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
        return "Airline {" +
                "name of company = '" + nameOfCompany + '\'' +
                ", location country = '" + locationCountry + '\'' +
                ", capacity of fleet = " + fleet.size() +
                " units}";
    }

    public String getStringOfFleetUnits()
    {
        StringBuilder buffer  = new StringBuilder();
        for (AbstractAircraft elem: fleet) {
            buffer.append(elem.toString() + "\n");
        }
        return buffer.toString();
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

    public AbstractAircraft findAircraftByParameters(int minRange, int maxRange, int minSpeed, int maxSpeed){
        for (AbstractAircraft elem: fleet) {
            if (elem.getRange()>=minRange && elem.getRange()<=maxRange && elem.getMaximumSpeed()>=minSpeed && elem.getMaximumSpeed()<=maxSpeed){
                return elem;
            }
        }
        return null;
    }

    public boolean addPlaneToPark(AbstractAircraft aircraft) {
        if (aircraft != null) {
            fleet.add(aircraft);
            return true;
        }
        return false;
    }


}
