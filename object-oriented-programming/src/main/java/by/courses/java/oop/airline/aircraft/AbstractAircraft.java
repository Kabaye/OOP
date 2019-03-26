package by.courses.java.oop.airline.aircraft;

public abstract class AbstractAircraft {
    private Integer range;
    private Integer maximumSpeed;
    private String model;
    private String producer;

    public AbstractAircraft(Integer range, Integer maximumSpeed, String model, String producer) {
        this.range = range;
        this.producer = producer;
        this.maximumSpeed = maximumSpeed;
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "plane {" +
                "producer = '" + producer + '\'' +
                ", model = '" + model + '\'' +
                ", range = " + range +
                " km, maximum speed = " + maximumSpeed +
                " kmh, ";
    }
}
