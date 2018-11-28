
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RoachMotel implements Subject{
    private static RoachMotel RM;
    private Map<Integer, Boolean> RM_map;
    private boolean noVacancySign;
    private ArrayList<Observer> waitList;
    
    private RoachMotel(){

        waitList = new ArrayList<>();
        RM_map = new HashMap<Integer,Boolean>();
    }
    
    public static RoachMotel getInstance(){
        if(RM == null){
            RM = new RoachMotel();
        }
        return RM;
    }
    
    public static String turnOnSign(){
        /*
        if(RM_map.size() == CAPACITY_SIZE){
            return "Sorry, we're full. No Vacancy."
        }
        String welcome = "Welcome, we have " + (CAPACITY_SIZE - RM_map.size()) + " rooms available.";
        return welcome;
        */
        return "placeholder, see psuedocode.";
    }

    public void createRooms(){
        for (int i = 1; i<6; i++) {
            RM_map.put(100 + i, true);
        }

    }

    @Override
    public void registerObserver(Observer o) {
        waitList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

        int i = waitList.indexOf(o);
        if (i >=0 ){
            waitList.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : waitList){

            o.update();
        }

    }
    

    public Room checkIn(RoachColony rc, String roomType, boolean foodBar, boolean spa, boolean shower){
        Room room;

        switch (roomType){
            case "deluxe" :
                room = new DeluxeRoom();
                break;

            case "suite" :
                room = new SuiteRoom();
                break;

            default:
                room = new RegularRoom();
                break;
        }

        if(foodBar){
            room.addAmenity(new FoodBarAmenity());
        } if (spa){
            room.addAmenity(new SpaAmenity());
        } if (shower){
            room.addAmenity(new SprayResistantShowerAmenity());
        }

        return room;
    }

    
    /*
    public static double checkOut(Room, int){
        double cost = Room.calculateRate();
        return cost;
    }
    */

    @Override
    public String toString() {
        return "Welcome to the roach motel! The following rooms are available: " + RM_map;
    }
}
