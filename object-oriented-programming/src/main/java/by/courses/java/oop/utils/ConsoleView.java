package by.courses.java.oop.utils;

import by.courses.java.oop.airline.aircraft.AbstractAircraft;
import by.courses.java.oop.airline.aircraft.CargoAircraft;
import by.courses.java.oop.airline.aircraft.PassengerAircraft;
import by.courses.java.oop.airline.Airline;

import java.util.*;

public class ConsoleView {
    public final static String BEGINNING = "Hello! Lets start!";
    public final static String COMMANDS = "Your commands: \n" +
            "1 --- print info about airline;\n" +
            "2 --- open add menu;\n" +
            "3 --- count total capacity and amount of seats;\n" +
            "4 --- sort airline's aircrafts by range;\n" +
            "5 --- search menu;\n" +
            "6 --- exit;";
    public final static String SEARCH = "Please, write min and max speed and range, we will find aircraft, which approach selected parameters";
    public final static String ADD = "Please, choose what type of aircraft you want to add:\n" +
            "1 --- passenger aircraft;\n" +
            "2 --- cargo aircraft;\n" +
            "3 --- fire fighter aircraft. Your choice: ";


    public static void print(Airline airline) {
        System.out.println(airline);
        print(airline.getAirFleet());
    }

    public static void print(List<AbstractAircraft> fleet) {
        for (AbstractAircraft elem : fleet) {
            System.out.println(elem);
        }
    }

    public static void printTotal(int capacity, int amountOfSeats) {
        System.out.println("Total amount of seats is: " + amountOfSeats + "; total capacity: " + capacity + ";");
    }

    public static void start() {
        System.out.println(BEGINNING);
        printCommands();
    }

    public static void printCommands() {
        System.out.println(COMMANDS);
    }

    public static void error() {
        System.out.println("Please, write just menu commands!");
        printCommands();
    }

    public static void close(Scanner input) {
        System.out.println("Goodbye!");
        input.close();
    }

    public static void searchMenu() {
        System.out.println(SEARCH);
    }

    public static void searchParameters(Scanner input, int minRange, int maxRange, int minSpeed, int maxSpeed) throws InputMismatchException {
        System.out.print("min range: ");
        minRange = input.nextInt();
        System.out.print("max range: ");
        maxRange = input.nextInt();
        System.out.print("min speed: ");
        minSpeed = input.nextInt();
        System.out.print("max speed: ");
        maxSpeed = input.nextInt();
    }

    public static void searchError(Scanner input) {
        System.out.println("Please, write just numbers!");
        input.nextLine();
    }
}
