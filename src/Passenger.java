import java.util.List;

public class Passenger {
    private String bookingReference;
    private String lastName;
    private String firstNames;
    private String flightCode;
    private Boolean checkedIn;
    private List<Bag> baggage;

    public Passenger(String bookingReference, String lastName, String firstNames, String flightCode) {
        this.bookingReference = bookingReference;
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.flightCode = flightCode;
        checkedIn = false;
    }
}
