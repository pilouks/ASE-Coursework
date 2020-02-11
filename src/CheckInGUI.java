import java.util.ArrayList;
import java.util.List;

public class CheckInGUI {

    public CheckInGUI(){}

    /*Will generate the standard gui layout
    * Home screen with no required input from user
    * Just a logo or something*/
    public void createAndShowGUI(){
        //to do
    }

    /*Will give the user the option to check in passenger or Exit
    * If check in passenger then request reference code and last name
    * Pass these back (comma separated)
    * If exit pass back "EXIT" to gen reports*/
    public String getUserInput(){
        //to do
        return "";
    }

    /*Will ask user for bag dimensions and weight
    * convert x,y,z dimensions to m^3 volume
    * pass back volume, weight*/
    public List<Double> getPassengerBagInfo(){
        //to do
        return new ArrayList<>();
    }

    /*Will request the user pay a fee for excess baggage
    * return true to indicate some sort of payment procedure has been passed
    * return false to indicate customer refusal to pay and bag should not be added*/
    public Boolean requestFees(double fee){
        //to do
        return true;
    }

    /*Show an error screen based on error code
    * 0: Generic error
    * 1: Booking code could not be found
    * 2: Booking code and last name did not match
    * 3: Bag dimensions unacceptable
    * 4: Baggage fees unpaid, bag not added
    *
    * Possibly more to come
    * Will return "OK" or something to indicate user wants to proceed*/
    public String ErrorScreen(int errorCode){
        //to do
        return "";
    }
}
