package by.courses.java.oop.Airline.Aircraft;

public abstract class AbstractAircraft {
    private Integer range;
    private Integer capacity; //грузоподъемность
    private Integer maximumSpeed;
    private String name;
    private Float fuselageWidth;
    private Integer length;

    public AbstractAircraft(Integer range, Integer capacity, Integer maximumSpeed, String name, Float fuselageWidth, Integer length) {
        this.range = range;
        this.capacity = capacity;
        this.maximumSpeed = maximumSpeed;
        this.name = name;
        this.fuselageWidth = fuselageWidth;
        this.length = length;
    }

    public Integer getRange() {
        return range;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    public String getName() {
        return name;
    }

    public Float getFuselageWidth() {
        return fuselageWidth;
    }

    public Integer getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "plane{" +
                "name = '" + name + '\'' +
                ", range = " + range +
                "km, capacity = " + capacity +
                "t, maximumSpeed = " + maximumSpeed +
                "kmh, fuselageWidth = " + fuselageWidth +
                "m, length=" + length +
                "m, ";
    }
}
