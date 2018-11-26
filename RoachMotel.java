
import java.util.Map;
import java.util.Queue;

public class RoachMotel {
    private static RoachMotel RM = new RoachMotel();
    //private Map<Integer, Room> RM_map;
    private boolean noVacancySign;
    //private Queue<RoachColony>;
    
    private RoachMotel(){
        
    }
    
    public static RoachMotel getInstance(){
        return RM;
    }
    
    /**
     * Other methods protected by singleton-ness
     */
    protected static void demo(){
        System.out.println("TESTING SINGLETON - IT WORKS");
    }
    
}
