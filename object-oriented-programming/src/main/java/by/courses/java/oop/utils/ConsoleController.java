package by.courses.java.oop.utils;

import by.courses.java.oop.airline.Airline;
import by.courses.java.oop.airline.aircraft.AbstractAircraft;
import by.courses.java.oop.airline.aircraft.CargoAircraft;
import by.courses.java.oop.airline.aircraft.PassengerAircraft;

import java.util.*;

public class ConsoleController {
    private Airline airline;

    public ConsoleController() {
        airline = new Airline("Emirates Concern", "UAE");

        airline.addPlaneToPark(new PassengerAircraft(10000, 985, "787-400", "Boeing", 150, 350));
        airline.addPlaneToPark(new PassengerAircraft(13500, 850, "340", "Airbus", 150, 400));
        airline.addPlaneToPark(new PassengerAircraft(9000, 800, "777-100", "Boeing", 100, 300));
        airline.addPlaneToPark(new PassengerAircraft(15000, 950, "A380", "Airbus", 155, 400));
        airline.addPlaneToPark(new PassengerAircraft(14000, 800, "777-9", "Boeing", 100, 550));
        airline.addPlaneToPark(new PassengerAircraft(15600, 1100, "A350-1000", "Airbus", 100, 300));

        airline.addPlaneToPark(new CargoAircraft(7000, 750, "Beluga", "Airbus", 2200, 80000));
        airline.addPlaneToPark(new CargoAircraft(8900, 900, "Beluga XL", "Airbus", 2650, 95500));
        airline.addPlaneToPark(new CargoAircraft(4500, 880, "Freighter 777F", "Boeing", 3000, 102000));
        airline.addPlaneToPark(new CargoAircraft(4500, 800, "Freighter 747-8F", "Boeing", 3200, 137000));
        airline.addPlaneToPark(new CargoAircraft(7400, 750, "A330-200F", "Airbus", 2000, 70000));
        airline.addPlaneToPark(new CargoAircraft(7800, 780, "A330P2F", "Airbus", 1700, 60000));
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        ConsoleView.start();
        String line;
        StringTokenizer tokenizer;
        boolean closeConsole = false;
        while (!closeConsole) {
            line = input.nextLine();
            if (!line.equals("")) {
                tokenizer = new StringTokenizer(line);
                switch (tokenizer.nextToken()) {
                    case "1": {
                        print();
                        break;
                    }
                    case "2": {
                        //addMenu
                        break;
                    }
                    case "3": {
                        countTotal();
                        break;
                    }
                    case "4": {
                        sort();
                        break;
                    }
                    case "5": {
                        search(input);
                        break;
                    }
                    case "6": {
                        closeConsole = true;
                        break;
                    }
                    default: {
                        ConsoleView.error();
                    }
                }
            }
        }
        ConsoleView.close(input);

    }

    private void print() {
        ConsoleView.print(airline);
    }

    private void countTotal() {
        int capacity = 0, amountOfSeats = 0;
        for (AbstractAircraft elem : airline.getAirFleet()) {
            if (elem instanceof PassengerAircraft) {
                amountOfSeats += ((PassengerAircraft) elem).getFirstClassSeats() + ((PassengerAircraft) elem).getSecondClassSeats();
            } else if (elem instanceof CargoAircraft) {
                capacity += ((CargoAircraft) elem).getCapacity();
            }
        }
        ConsoleView.printTotal(capacity, amountOfSeats);
    }

    private void sort() {
        List<AbstractAircraft> aircrafts = airline.getAirFleet();
        aircrafts.sort(Comparator.comparing(AbstractAircraft::getRange));
        ConsoleView.print(aircrafts);
    }

    private void search(Scanner input) {
        ConsoleView.searchMenu();
        int minRange, maxRange, minSpeed, maxSpeed;
        while (true)
            try {
                System.out.print("min range: ");
                minRange = input.nextInt();
                System.out.print("max range: ");
                maxRange = input.nextInt();
                System.out.print("min speed: ");
                minSpeed = input.nextInt();
                System.out.print("max speed: ");
                maxSpeed = input.nextInt();
                ConsoleView.printSearchedAircraft(searchAircraftByParameters(airline.getAirFleet(), minRange, maxRange, minSpeed, maxSpeed));
                break;

            } catch (InputMismatchException exc) {
                ConsoleView.searchError(input);
            }
    }

    private AbstractAircraft searchAircraftByParameters(List<AbstractAircraft> fleet, int minRange, int maxRange, int minSpeed, int maxSpeed) {
        for (AbstractAircraft elem :
                fleet) {
            if (elem.getMaximumSpeed() <= maxSpeed && elem.getMaximumSpeed() >= minSpeed && elem.getRange() >= minRange && elem.getRange() <= maxRange)
                return elem;
        }
        return null;
    }
}
