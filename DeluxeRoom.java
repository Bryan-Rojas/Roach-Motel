
public class DeluxeRoom extends Room {
    @Override
    public double cost(){
        return getBaseRate();
    }
    
    @Override
    public void addAmenities(){
        //Adds nothing to the set of amenities.
    }
}
