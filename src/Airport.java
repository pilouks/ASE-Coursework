import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Passenger> waitingRoom;
    private List<Flight> planes;

    public Airport(){
        waitingRoom = new ArrayList<>();
        planes = new ArrayList<>();
    }

    /*Will take in bag size, weight and fee status
    * Will check if excess baggage fees are to be paid
    * If no will add bag to passenger return with 0.0
    * If yes will not add bag and return with fee cost
    * Once fee is paid, baggage addition request can be made
    * with fee status set as paid*/
    public double addBagToPassenger(){
        //to do
        return 0.0;
    }
}
