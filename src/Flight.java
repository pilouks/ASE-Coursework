import java.util.List;

public class Flight {

    private String flightCode;
    private String destination;
    private String carrier;
    private int maxPassenger;
    private int maxWeight;
    private int maxVolume;
    private List<Passenger> passengerList;

    public Flight(String flightCode, String destination, String carrier, int maxPassenger, int maxWeight, int maxVolume) {
        this.flightCode = flightCode;
        this.destination = destination;
        this.carrier = carrier;
        this.maxPassenger = maxPassenger;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }
}
