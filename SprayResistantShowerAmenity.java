/**
 * December 5, 2018
 * Purpose: Decorated class to describe the Spray Resistant Shower Amenity as well as the cost
 * Inputs:
 * Output: description, and cost of Spray Resistant Shower
 *
 */

public class SprayResistantShowerAmenity extends AmenityDecorator{
    /*
    * 
    *  Default constructor - no body 
    */
    public SprayResistantShowerAmenity(){}

    /**
     * @return String description of Spray Resistant Shower
     */
    public String getDescription(){
        return "Spray Resistant Shower";
    }

    /**
     * @return Cost of Spray Resistant Shower
     */
    public double cost(){
        return 25.00;
    }

    @Override
    public String toString() {
        return "This is a Spray resistant shower amenity with a cost of " + cost();
    }
}


