package checkIn;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String bookingReference;
    private String lastName;
    private String firstNames;
    private String flightCode;
    private Boolean checkedIn;
    private List<Bag> baggage;

    public Passenger(String bookingReference, String lastName, String firstNames, String flightCode, Boolean checkedIn) {
        this.bookingReference = bookingReference;
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.flightCode = flightCode;
        this.checkedIn = checkedIn;
        baggage = new ArrayList<>();
    }


    /*Changes check in status to true
    * Throws error if already checked in
    * Use custom exception*/
    public void CheckIn() throws CheckInException{
        if(checkedIn==false) {
        	checkedIn=true;
        }
    	throw new CheckInException(this.bookingReference);
    }


    /*Creates new bag object
    * Adds new bag to list in passenger*/
    public void addBag(Bag b){
        baggage.add(b);
    }

    /*Will sum the total weight of all the baggage this passenger has*/
    public double totalWeight(){
    	double totalWeight=0.0;
    	for (Bag num : baggage) {
    		totalWeight += num.getWeight();
       }
        return totalWeight;
    }


    /*Will sum up the total size of all the baggage this passenger has*/
    public double totalSize(){
    	double totalSize=0.0;
    	for (Bag num : baggage) {
    		totalSize += num.getSize();
       }
        return totalSize;
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
