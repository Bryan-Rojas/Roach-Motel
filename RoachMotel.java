
import java.util.Map;
import java.util.Queue;

public class RoachMotel {
    private static RoachMotel RM;
    //private Map<Integer, Room> RM_map;
    private boolean noVacancySign;
    //private Queue<RoachColony>;
    
    private RoachMotel(){}
    
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
    
    /*
    public static Room checkIn(RoachColony rc, String str, Amenity am){
        return Room object;
    }
    */
    
    /*
    public static double checkOut(Room, int){
        double cost = Room.calculateRate();
        return cost;
    }
    */
    
}
