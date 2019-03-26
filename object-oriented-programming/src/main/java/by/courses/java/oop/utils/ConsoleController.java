package by.courses.java.oop.utils;

import by.courses.java.oop.airline.Airline;
import by.courses.java.oop.airline.aircraft.CargoAircraft;
import by.courses.java.oop.airline.aircraft.FireFightingAircraft;
import by.courses.java.oop.airline.aircraft.PassengerAircraft;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

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

        airline.addPlaneToPark(new FireFightingAircraft(750, 400, "144SP", "Tu", 35, true));
        airline.addPlaneToPark(new FireFightingAircraft(500, 500, "DC-10", "Douglass", 45, false));
        airline.addPlaneToPark(new FireFightingAircraft(500, 500, "BE-200", "Beriev", 20, true));
        airline.addPlaneToPark(new FireFightingAircraft(500, 500, "76", "IL", 40, true));

        run();
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
                        add(input);
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
                        ConsoleView.error(ConsoleView.COMMANDS);
                    }
                }
            }
        }
        ConsoleView.close(input);

    }

    private void print() {
        ConsoleView.print(airline);
    }

    private void add(Scanner input) {
        ConsoleView.print(ConsoleView.ADD);
        int type;
        int range, maxSpeed;
        String model, producer;
        boolean addCompleted = false;
        while (!addCompleted) {
            try {
                type = input.nextInt();
                ConsoleView.print("range = ");
                range = input.nextInt();
                ConsoleView.print("maxSpeed = ");
                maxSpeed = input.nextInt();
                ConsoleView.print("producer = ");
                producer = input.next();
                ConsoleView.print("model = ");
                model = input.next();

                switch (type) {
                    case 1: {
                        int firstClass, secondClass;
                        ConsoleView.print("first class seats = ");
                        firstClass = input.nextInt();
                        ConsoleView.print("second class seats = ");
                        secondClass = input.nextInt();
                        airline.addPlaneToPark(new PassengerAircraft(range, maxSpeed, model, producer, firstClass, secondClass));
                        addCompleted = true;
                        break;
                    }
                    case 2: {
                        int cargoVolume, capacity;
                        ConsoleView.print("cargo volume = ");
                        cargoVolume = input.nextInt();
                        ConsoleView.print("capacity = ");
                        capacity = input.nextInt();
                        airline.addPlaneToPark(new CargoAircraft(range, maxSpeed, model, producer, cargoVolume, capacity));
                        addCompleted = true;
                        break;
                    }
                    case 3: {
                        int boilersVolume;
                        int externBoilerFlag;
                        boolean externBoiler;
                        ConsoleView.print("boilers volume = ");
                        boilersVolume = input.nextInt();
                        ConsoleView.print("availability to have external boiler (1 or 0) = ");
                        externBoilerFlag = input.nextInt();
                        if (externBoilerFlag == 1) {
                            externBoiler = true;
                        } else if (externBoilerFlag == 0) {
                            externBoiler = false;
                        } else throw new InputMismatchException();
                        airline.addPlaneToPark(new FireFightingAircraft(range, maxSpeed, model, producer, boilersVolume, externBoiler));
                        addCompleted = true;
                        break;
                    }

                }
            } catch (InputMismatchException exc) {
                ConsoleView.error(ConsoleView.ADD);
                input.nextLine();
            }
        }
        ConsoleView.print("Adding ended!");
    }

    private void countTotal() {
        ConsoleView.printTotal(airline.countTotalCapacity(), airline.countAmountOfSeats());
    }

    private void sort() {
        airline.sort();
        ConsoleView.print(airline);
    }

    private void search(Scanner input) {
        ConsoleView.print(ConsoleView.SEARCH);
        int minRange, maxRange, minSpeed, maxSpeed;
        while (true)
            try {
                ConsoleView.print("min range: ");
                minRange = input.nextInt();
                ConsoleView.print("max range: ");
                maxRange = input.nextInt();
                ConsoleView.print("min speed: ");
                minSpeed = input.nextInt();
                ConsoleView.print("max speed: ");
                maxSpeed = input.nextInt();
                ConsoleView.printSearchedAircraft(airline.searchAircraftByParameters(minRange, maxRange, minSpeed, maxSpeed));
                break;

            } catch (InputMismatchException exc) {
                ConsoleView.error(ConsoleView.SEARCH);
                input.nextLine();
            }
    }


}
