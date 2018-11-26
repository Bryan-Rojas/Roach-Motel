
import java.util.Set;

public abstract class Room {
    private String description;
    private double baseRate;
    private double rate;
    //private Set<Amenity> amenities;
    
    public String getDescription(){
        return description;
    }
    
    public abstract double cost();
    
}
