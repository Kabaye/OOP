package by.courses.java.oop.Airline.Aircraft;

public class PassengerAircraft extends AbstractAircraft {
    private Integer firstClassSeats;
    private Integer secondClassSeats;

    public PassengerAircraft(Integer range, Integer capacity, Integer maximumSpeed, String name, Float fuselageWidth, Integer length, Integer firstClassSeats, Integer secondClassSeats) {
        super(range, capacity, maximumSpeed, name, fuselageWidth, length);
        this.firstClassSeats = firstClassSeats;
        this.secondClassSeats = secondClassSeats;
    }

    public Integer getFirstClassSeats() {
        return firstClassSeats;
    }

    public Integer getSecondClassSeats() {
        return secondClassSeats;
    }

    @Override
    public String toString() {
        return  super.toString()+"first class seats = " + firstClassSeats +
                ", second class seats = " + secondClassSeats +
                "}";
    }
}
