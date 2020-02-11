import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String flightCode;
    private String destination;
    private String carrier;
    private int maxPassenger;
    private int maxWeight;
    private int maxVolume;
    private List<Passenger> passengerList;
    private double excessFees;

    public Flight(String flightCode, String destination, String carrier, int maxPassenger, int maxWeight, int maxVolume) {
        this.flightCode = flightCode;
        this.destination = destination;
        this.carrier = carrier;
        this.maxPassenger = maxPassenger;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }


    /*Will get the total weights from each passenger on the flight
    * and sum them for use in the report*/
    public double sumFlightWeight(){
        //to do
        return 0.0;
    }

    /*Will get the total weights from each of the passengers on the
    * flight and sum them for use in the report*/
    public double sumFlightSize(){
        //to do
        return 0.0;
    }

    /*Will generate a report on the flight based on:
    * - Number of passengers checked in
    * - total weight of baggage
    * - total size of baggage
    * - excess baggage fees
    * - if the flight is over capacity
    * Will auto format the report into a single string for writing to file*/
    public String report(){
        //to do
        return "";
    }

    /*Will take a passenger with their baggage already added and
    * add to the flights list of passengers then set the passenger
    * check in status to true*/
    public void checkInToFlight(){
        //to do
    }

    //Auto generated getters and setters

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public double getExcessFees() {
        return excessFees;
    }

    public void setExcessFees(double excessFees) {
        this.excessFees = excessFees;
    }
}
