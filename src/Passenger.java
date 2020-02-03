import java.util.ArrayList;
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


    /*Changes check in status to true
    * Throws error if already checked in
    * Use custom exception*/
    public void CheckIn(){
        //to do
    }


    /*Creates new bag object
    * Adds new bag to list in passenger*/
    public void addBag(){
        //to do
    }

    /*Will sum the total weight of all the baggage this passenger has*/
    public double totalWeight(){
        //to do
        return 0.0;
    }


    /*Will sum up the total size of all the baggage this passenger has*/
    public List<Double> totalSize(){
        //to do
        return new ArrayList<>();
    }


    //Auto generated getter and setters
    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
}
