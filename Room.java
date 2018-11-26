
import java.util.Set;

public class Room {
    private String description;
    private double baseRate;
    private double rate;
    //private Set<Amenity> amenities;
    
    public String getDescription(){
        return description;
    }
    
    public double cost(){
        return baseRate;
    }
    
    public void addAmenities(){
        //Adds nothing to the set of amenities.
    }
}
