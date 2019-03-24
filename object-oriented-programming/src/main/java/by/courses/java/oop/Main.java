package by.courses.java.oop;

import by.courses.java.oop.Airline.Aircraft.CargoAircraft;
import by.courses.java.oop.Airline.Aircraft.PassengerAircraft;
import by.courses.java.oop.Airline.Airline;
import by.courses.java.oop.Utils.ConsoleOperator;

public class Main {
    public static void main(String[] args) {
        Airline airline = new Airline("Emirates Concern", "UAE");
        airline.addPlaneToPark(new PassengerAircraft(10000,985, "787-400","Boeing", 150,350));
        airline.addPlaneToPark(new PassengerAircraft(13500,850, "340","Airbus", 150,400));
        airline.addPlaneToPark(new PassengerAircraft(9000,800, "777-100","Boeing", 100,300));
        airline.addPlaneToPark(new PassengerAircraft(15000,950, "A380","Airbus", 155,400));
        airline.addPlaneToPark(new PassengerAircraft(14000,800, "777-9","Boeing", 100,550));
        airline.addPlaneToPark(new PassengerAircraft(15600,1100, "A350-1000","Airbus", 100,300));

        airline.addPlaneToPark(new CargoAircraft(7000,750, "Beluga","Airbus", 2200,80000));
        airline.addPlaneToPark(new CargoAircraft(8900,900, "Beluga XL","Airbus", 2650,95500));
        airline.addPlaneToPark(new CargoAircraft(4500,880, "Freighter 777F","Boeing", 3000,102000));
        airline.addPlaneToPark(new CargoAircraft(4500,800, "Freighter 747-8F","Boeing", 3200,137000));
        airline.addPlaneToPark(new CargoAircraft(7400,750, "A330-200F","Airbus", 2000,70000));
        airline.addPlaneToPark(new CargoAircraft(7800,780, "A330P2F","Airbus", 1700,60000));

        new ConsoleOperator(airline)
                .workWithConsole();

    }
}
