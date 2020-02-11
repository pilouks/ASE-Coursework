import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Passenger> waitingRoom;
    private List<Flight> planes;

    public Airport(){
        waitingRoom = new ArrayList<>();
        planes = new ArrayList<>();
    }

    /*Will be called main
    * Contains code for main running loop/process
    * Non static content*/
    public void run(){
        //to do
    }

    /*Will read in flight data from file
    * And store within flight list*/
    public void readFlightData(){
        //to do
    }

    /*Will read in passenger data from file
    * and store within passenger list waitingRoom*/
    public void readPassengerData(){
        //to do
    }

    /*Will create a new passenger and store it in waiting room
    * may be redundant, come back to this*/
    public void addPassenger(){
        //to do
    }

    /*Will call gui to get bag information
    * Will verify baggage size and weight
    * Will call gui to request excess fees if required
    * Will add bag to passenger and return with excess fees paid*/
    public double addBagToPassenger(){
        //to do
        return 0.0;
    }

    /*Will create a new flight and store it in flight list
     * may be redundant, come back to this*/
    public void addFlight(){
        //to do
    }

    /*Will call each flight to generate a report and store in list*/
    public List<String> collectReports(){
        //to do
        return new ArrayList<>();
    }

    /*Takes in list of reports and formats them into longform final output string
    * Can possible write this to file as well as return*/
    public String writeReport(){
        //to do
        return "";
    }

    /*Will sort passengers based of reference code
    * for faster finding*/
    public void SortPassengers(){
        //to do
    }

    /*Will find a passenger from reference code in sorted list*/
    public Passenger findPassenger(){
        //to do
        return new Passenger("", "", "", "");
    }

    /*Main, duh*/
    public static void main(String[] args){
        //to do
    }
}
