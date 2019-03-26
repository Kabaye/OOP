package by.courses.java.oop.airline;

import by.courses.java.oop.airline.aircraft.AbstractAircraft;
import by.courses.java.oop.airline.aircraft.CargoAircraft;
import by.courses.java.oop.airline.aircraft.PassengerAircraft;

import java.util.ArrayList;
import java.util.Comparator;
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

    public int countAmountOfSeats() {
        int amountOfSeats = 0;
        for (AbstractAircraft elem : fleet) {
            if (elem instanceof PassengerAircraft) {
                amountOfSeats += ((PassengerAircraft) elem).getFirstClassSeats() + ((PassengerAircraft) elem).getSecondClassSeats();
            }
        }
        return amountOfSeats;
    }

    public int countTotalCapacity() {
        int capacity = 0;
        for (AbstractAircraft elem : fleet) {
            if (elem instanceof CargoAircraft) {
                capacity += ((CargoAircraft) elem).getCapacity();
            }
        }
        return capacity;
    }

    public void sort() {
        fleet.sort(Comparator.comparing(AbstractAircraft::getRange));
    }

    public AbstractAircraft searchAircraftByParameters(int minRange, int maxRange, int minSpeed, int maxSpeed) {
        for (AbstractAircraft elem : fleet) {
            if (elem.getMaximumSpeed() <= maxSpeed && elem.getMaximumSpeed() >= minSpeed && elem.getRange() >= minRange && elem.getRange() <= maxRange)
                return elem;
        }
        return null;
    }

}
