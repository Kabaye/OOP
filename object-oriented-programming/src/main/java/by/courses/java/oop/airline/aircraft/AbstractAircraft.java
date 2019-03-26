package by.courses.java.oop.Airline.Aircraft;

public abstract class AbstractAircraft {
    private Integer range;
    private Integer maximumSpeed;
    private String model;
    private PlaneProducer producer;

    public AbstractAircraft(Integer range, Integer maximumSpeed, String model, String producer) {
        this.range = range;
        this.producer = PlaneProducer.valueOf(producer.toUpperCase());
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
                "producer = '" + producer.toString().toLowerCase() + '\'' +
                ", model = '" + model + '\'' +
                ", range = " + range +
                " km, maximum speed = " + maximumSpeed +
                " kmh, ";
    }
}
