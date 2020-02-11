import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Airport {

    private HashMap<String, Passenger> waitingRoom;
    private HashMap<String, Flight> planes;
    private CheckInGUI GUI;

    private int maxBagSize = 5;
    private int maxBagWeight = 100;
    private int feePerExtraBag = 25;
    private int excessBagSize = 3;
    private int excessBagWeight = 20;
    private int excessFee = 50;

    public Airport(){
        waitingRoom = new HashMap<>();
        planes = new HashMap<>();
        GUI = new CheckInGUI();
    }

    /*Will be called main
    * Contains code for main running loop/process
    * Non static content*/
    public void run(){
        //to do
    }

    /*Will read in flight data from file
    * And store within flight map*/
    public void readFlightData(String fileName){
        //done
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(fileName));
            String inputLine = br.readLine();
            while(inputLine != null){
                String[] data = inputLine.split(",");
                for(int i = 0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                Flight f = new Flight(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                planes.put(data[0], f);
                inputLine = br.readLine();
            }

        } catch(FileNotFoundException e) {
            System.out.println("FLight data file not found\n" + e);
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            try{
                br.close();
            } catch(IOException e){
                //do nothing
            }
        }
    }

    /*Will read in passenger data from file
    * and store within passenger map waitingRoom*/
    public void readPassengerData(String fileName){
        //done
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(fileName));
            String inputLine = br.readLine();
            while(inputLine != null){
                String[] data = inputLine.split(",");
                for(String item : data){
                    item.trim();
                }
                Boolean checked = Boolean.parseBoolean(data[4]);
                Passenger p = new Passenger(data[0], data[1], data[2], data[3], checked);
                if(checked){
                    planes.get(data[3]).addPassenger(p);
                } else {
                    waitingRoom.put(data[0], p);
                }
                inputLine = br.readLine();
            }
        } catch(FileNotFoundException e) {
            System.out.println("FLight data file not found\n" + e);
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            try{
                br.close();
            } catch(IOException e){
                //do nothing
            }
        }
    }

    /*Will call gui to get bag information
    * Will verify baggage size and weight
    * Will call gui to request excess fees if required
    * Will add bag to passenger and return with excess fees paid*/
    public double addBagToPassenger(String reference, int bagNumber){
        //done
        List<Double> info = GUI.getPassengerBagInfo();
        double bagVol = info.get(0);
        double bagWeight = info.get(1);
        while((bagVol > maxBagSize)||(bagWeight > maxBagWeight)){
            GUI.ErrorScreen(3);
            info = GUI.getPassengerBagInfo();
            bagVol = info.get(0);
            bagWeight = info.get(1);
        }
        double fee = 0.0;
        //generate fees
        fee += (bagNumber * feePerExtraBag);
        if(bagVol > excessBagSize){
            fee += excessFee;
        }
        if(bagWeight > excessBagWeight){
            fee += excessFee;
        }
        //request fee from user and add bag
        if(fee > 0){
            if(GUI.requestFees(fee)){
                Bag b = new Bag(bagVol, bagWeight);
                waitingRoom.get(reference).addBag(b);
                return fee;
            } else {
                GUI.ErrorScreen(4);
                return 0.0;
            }
        } else { //no fee required, just add bag
            Bag b = new Bag(bagVol, bagWeight);
            waitingRoom.get(reference).addBag(b);
            return 0.0;
        }
    }

    /*Will call each flight to generate a report and store in list*/
    public List<String> collectReports(){
        //done
        Set<String> flightList = planes.keySet();
        List<String> reports = new ArrayList<>();

        for(String key : flightList){
            reports.add(planes.get(key).report());
        }

        return reports;
    }

    /*Takes in list of reports and formats them into longform final output string
    * write this to file as well as return*/
    public String writeReport(){
        //done
        String fullReport = "";
        List<String> reports = collectReports();


        fullReport += "Report from completed session\n";
        fullReport += java.time.LocalDate.now() + "\n\n";
        for(String line : reports){
            fullReport += line;
            fullReport += "\n";
        }

        String fileName = "report" + java.time.LocalDate.now() + java.time.LocalTime.now() ;
        try{
            File write = new File(fileName);
            if(!write.exists()) {
                write.createNewFile();
            }
        } catch(IOException e){
            e.printStackTrace();
        }

        try{
            FileWriter fw = new FileWriter(fileName);
            fw.write(fullReport);
        } catch(IOException e){
            e.printStackTrace();
        }
        return fullReport;
    }

    /*Main, duh*/
    public static void main(String[] args){

    }
}
