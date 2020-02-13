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
        excessFees = 0.0;
        passengerList = new ArrayList<Passenger>();
    }


    /*Will get the total weights from each passenger on the flight
    * and sum them for use in the report*/
    public double sumFlightWeight(){
    	double totalFlightWeight = 0;
        for (int i = 0; passengerList.size() > i; i++){
        	Passenger passenger = passengerList.get(i);
        	totalFlightWeight += passenger.totalWeight();
        }
        try {
        	if (totalFlightWeight > maxWeight){
        		throw new Exception("Flight is over its max baggage weight!");
        	}
			}catch (Exception e){
				e.printStackTrace();
		}
        return totalFlightWeight;
    }

    /*Will get the total size from each of the passengers on the
    * flight and sum them for use in the report*/
    public double sumFlightSize(){
    	double totalFlightSize = 0;
        for (int i = 0; passengerList.size() > i; i++){
        	Passenger passenger = passengerList.get(i);
        	totalFlightSize += passenger.totalSize();
        }
    	try {
    		if (totalFlightSize > maxVolume){
    			throw new Exception("Flight is over its max baggage volume!");
    		}
		}catch (Exception e){
			e.printStackTrace();
		}
        return totalFlightSize;
    }

    /*Will generate a report on the flight based on:
    * - Number of passengers checked in
    * - total weight of baggage
    * - total size of baggage
    * - excess baggage fees
    * - if the flight is over capacity
    * Will auto format the report into a single string for writing to file*/
    public String report(){
        String report = "";
        report += "FLIGHT REPORT" + "\n";
        report += "- Number of passengers checked in: " + passengerList.size() + "\n";
        report += "- Total weight of baggage on flight: " + sumFlightWeight() + "\n";
        report += "- Total size of baggage on flight: " + sumFlightSize() + "\n";
        report += "- Total excess fees: " + excessFees + "\n";
        if (passengerList.size() > maxPassenger){
        	report += "FLIGHT IS OVER CAPACITY!" + "\n";
        }else{
        	report += "flight is within capacity" + "\n";
        }
        return report;
    }

    /*Will take a passenger with their baggage already added and
    * add to the flights list of passengers then set the passenger
    * check in status to true*/
    public void checkInToFlight(Passenger passenger){
    	try{
    		if (passengerList.size() < maxPassenger){
    			passenger.CheckIn();
    			passengerList.add(passenger);
    		} else {
    			throw new Exception("flight is at max capacity!");
    		}
    		
    	}catch (Exception e){
    		e.printStackTrace();
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
