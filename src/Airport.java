import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Passenger> waitingRoom;
    private List<Flight> planes;

    public Airport(){
        waitingRoom = new ArrayList<>();
        planes = new ArrayList<>();
    }
}
