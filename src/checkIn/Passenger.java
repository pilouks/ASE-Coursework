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

    public Passenger(String bookingReference, String lastName, String firstNames, String flightCode, Boolean checkedIn) throws InvalidDataException {
        if(invalidBookingReference(bookingReference)){
            throw new InvalidDataException("The booking reference: " + bookingReference + " is invalid.");
        } else {
            this.bookingReference = bookingReference;
        }
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.flightCode = flightCode;
        this.checkedIn = checkedIn;
        baggage = new ArrayList<>();
    }

    public Boolean invalidBookingReference(String ref){
        if(ref.length() == 12){
            return !Character.isLetter(ref.charAt(0)) ||
                    !Character.isLetter(ref.charAt(1)) ||
                    !Character.isDigit(ref.charAt(2)) ||
                    !Character.isDigit(ref.charAt(3)) ||
                    !Character.isDigit(ref.charAt(4)) ||
                    !Character.isDigit(ref.charAt(5)) ||
                    !Character.isDigit(ref.charAt(6)) ||
                    !Character.isDigit(ref.charAt(7)) ||
                    !Character.isDigit(ref.charAt(8)) ||
                    !Character.isDigit(ref.charAt(9)) ||
                    !Character.isLetter(ref.charAt(10)) ||
                    !Character.isLetter(ref.charAt(11));
        }
        return true;
    }


    /*Changes check in status to true
    * Throws error if already checked in
    * Use custom exception*/
    public void CheckIn() throws CheckInException{
        if(checkedIn==false) {
        	checkedIn=true;
        } else {
            throw new CheckInException(this.bookingReference);
        }
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
    public String getLastName() {
        return lastName;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }
}
