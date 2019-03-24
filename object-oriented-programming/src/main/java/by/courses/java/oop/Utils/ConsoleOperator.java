package by.courses.java.oop.Utils;

import by.courses.java.oop.Airline.Aircraft.AbstractAircraft;
import by.courses.java.oop.Airline.Aircraft.CargoAircraft;
import by.courses.java.oop.Airline.Aircraft.PassengerAircraft;
import by.courses.java.oop.Airline.Airline;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConsoleOperator {
    public final static String BEGINNING = "Hello! Lets start! Our commands is:\n" +
            "1 --- print info about airline;\n" +
            "2 --- count total capacity and amount of seats;\n" +
            "3 --- sort airline's aircrafts by range;\n" +
            "4 --- search menu;\n" +
            "5 --- exit;\n";

    private Airline airline;

    public ConsoleOperator(Airline airline) {
        this.airline = airline;
    }

    public void workWithConsole() {
        Scanner input = new Scanner(System.in);
        System.out.print(BEGINNING);
        String line;
        StringTokenizer tokenizer;
        boolean closeConsole = false;
        if (airline != null)
            while (!closeConsole) {
                line = input.nextLine();
                tokenizer = new StringTokenizer(line);
                switch (tokenizer.nextToken()) {
                    case "1": {
                        print();
                        break;
                    }
                    case "2": {
                        countTotal();
                        break;
                    }
                    case "3": {
                        sort();
                        break;
                    }
                    case "5": {
                        closeConsole = true;
                        break;
                    }
                }
            }
        input.close();
    }

    private void print() {
        System.out.print(airline + "\n" + airline.getStringOfFleetUnits());
    }

    private void countTotal() {
        Integer capacity = 0, amountOfSeats = 0;
        for (AbstractAircraft elem : airline.getAirFleet()) {
            if (elem instanceof PassengerAircraft) {
                amountOfSeats += ((PassengerAircraft) elem).getFirstClassSeats() + ((PassengerAircraft) elem).getSecondClassSeats();
            } else if (elem instanceof CargoAircraft) {
                capacity += ((CargoAircraft) elem).getCapacity();
            }
        }
        System.out.println("Total amount of seats is: " + amountOfSeats + "; total capacity: " + capacity + ";");
    }

    private void sort() {
        List<AbstractAircraft> aircrafts = airline.getAirFleet();
        aircrafts.sort(Comparator.comparing(AbstractAircraft::getRange));
        for (AbstractAircraft elem: aircrafts) {
            System.out.println(elem);
        }
    }

}
