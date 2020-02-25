package checkIn;

import java.util.ArrayList;
import java.util.List;

public class Flight {

	// Unique code that differentiates each flight from another, allowing passengers to find the correct flight to check in to.
    private String flightCode;
    // The destination of the flight
    private String destination;
    // The carrier of the flight
    private String carrier;
    // max capacities of the flight, passenger, baggage weight and baggage volume
    private int maxPassenger;
    private int maxWeight;
    private int maxVolume;
    // A list of all the passengers checked-in to the flight
    private List<Passenger> passengerList;
    // The amount of excess fees associated with the flight, due to extra baggage weight/limit from passenger.
    private double excessFees;
    
    public Flight(String flightCode, String destination, String carrier, int maxPassenger, int maxWeight, int maxVolume) throws InvalidDataException {
        if(invalidFlightCode(flightCode)){
            throw new InvalidDataException("Flight code: "+ flightCode + " is invalid");
        } else {
            this.flightCode = flightCode;
        }
        this.destination = destination;
        this.carrier = carrier;
        this.maxPassenger = maxPassenger;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
        excessFees = 0.0;
        passengerList = new ArrayList<Passenger>();
    }

    private Boolean invalidFlightCode(String code){
        if(code.length() == 6){
            if(Character.isLetter(code.charAt(0)) && Character.isLetter(code.charAt(1))){
                return false;
            }
        }
        return true;
    }


    /*Will get the total baggage weight from each passenger on the flight
    * and sum them for use in the report*/
    public double sumFlightWeight(){
    	double totalFlightWeight = 0;
        for (int i = 0; passengerList.size() > i; i++){
        	Passenger passenger = passengerList.get(i);
        	totalFlightWeight += passenger.totalWeight();
        }
        return totalFlightWeight;
    }

    /*Will get the total baggage size from each of the passengers on the
    * flight and sum them for use in the report*/
    public double sumFlightSize(){
    	double totalFlightSize = 0;
        for (int i = 0; passengerList.size() > i; i++){
        	Passenger passenger = passengerList.get(i);
        	totalFlightSize += passenger.totalSize();
        }
        return totalFlightSize;
    }

    /*Will generate a report on the flight based on:
    * - The flight code and destination of the flight
    * - Number of passengers checked in
    * - total weight of baggage
    * - total size of baggage
    * - excess baggage fees
    * - if the flight is over capacity and/or over max baggage weight and/or over max baggage volume
    * Will auto format the report into a single string for writing to file*/
    public String report(){
    	double flightWeight = sumFlightWeight();
    	double flightSize = sumFlightSize();
        String report = "";
        report += "FLIGHT REPORT: " + flightCode + " to " + destination + "\n";
        report += "- Number of passengers checked in: " + passengerList.size() + "\n";
        report += "- Total weight of baggage on flight: " + flightWeight + "\n";
        report += "- Total size of baggage on flight: " + flightSize + "\n";
        report += "- Total excess fees: " + excessFees + "\n";
        if (passengerList.size() > maxPassenger){
        	report += "FLIGHT IS OVER CAPACITY!" + "\n";
        }
        if (flightWeight > maxWeight){
        	report += "FLIGHT IS OVER MAX BAGGAGE WEIGHT!" + "\n";
        }
        if (flightSize > maxVolume){
        	report += "FLIGHT IS OVER MAX BAGGAGE VOLUME!" + "\n";
        }
        return report;
    }

    /*Will take a passenger with their baggage already added and
    * add to the flights list of passengers then set the passenger
    * check in status to true*/
    public void checkInToFlight(Passenger passenger, double fees){
    	try{
			passenger.CheckIn();
			passengerList.add(passenger);
			excessFees += fees;
    	}catch (CheckInException e){
            System.out.println(e.getMessage());
    	}
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

    public void addPassenger(Passenger p){
        this.passengerList.add(p);
    }

    public double getExcessFees() {
        return excessFees;
    }

    public void setExcessFees(double excessFees) {
        this.excessFees = excessFees;
    }
}
