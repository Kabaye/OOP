package by.courses.java.oop.utils;

import by.courses.java.oop.airline.Airline;
import by.courses.java.oop.airline.aircraft.AbstractAircraft;

import java.util.Scanner;

public class ConsoleView {
    public final static String BEGINNING = "Hello! Lets start!";
    public final static String COMMANDS = "Your commands: \n" +
            "1 --- print info about airline;\n" +
            "2 --- open add menu;\n" +
            "3 --- count total capacity and amount of seats;\n" +
            "4 --- sort airline's aircrafts by range;\n" +
            "5 --- search menu;\n" +
            "6 --- exit;\n";
    public final static String SEARCH = "Please, write min and max speed and range, we will find aircraft, which approach selected parameters";
    public final static String ADD = "Please, choose what type of aircraft you want to add:\n" +
            "1 --- passenger aircraft;\n" +
            "2 --- cargo aircraft;\n" +
            "3 --- fire fighter aircraft. Your choice: ";

    public static void print(String str) {
        System.out.print(str);
    }

    public static void print(Airline airline) {
        System.out.println(airline);
        for (AbstractAircraft elem : airline.getAirFleet()) {
            System.out.println(elem);
        }
    }

    public static void printTotal(int capacity, int amountOfSeats) {
        System.out.println("Total amount of seats is: " + amountOfSeats + "; total capacity: " + capacity + ";");
    }

    public static void start() {
        System.out.println(BEGINNING);
        print(COMMANDS);
    }

    public static void error(String str) {
        System.out.println("Please, write just menu commands!");
        print(str);
    }

    public static void close(Scanner input) {
        System.out.println("Goodbye!");
        input.close();
    }

    public static void printSearchedAircraft(AbstractAircraft aircraft) {
        if (aircraft == null) {
            System.out.println("There is no such aircraft, which approach selected parameters!");
        } else {
            System.out.println("We found this aircraft: " + aircraft);
        }
    }
}
