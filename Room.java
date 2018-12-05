
import java.util.HashSet;
import java.util.Set;

public abstract class Room {
    private String description;
    private double baseRate;
    private double rate;
    private Set<AmenityDecorator> amenities;

    public Room(){

        amenities = new HashSet<>();

    }
    public String getDescription(){
        return description;
    }

    public abstract double cost();

    public void addAmenity(AmenityDecorator ad){
        amenities.add(ad);
    }

    public double getAmenityCost() {
        Double cost = 0.0;

        for(AmenityDecorator amenity : amenities) {
            cost += amenity.cost();
        }

        return cost;
    }

    @Override
    public String toString() {
        String str = "This is a " + this.getClass().getName() + " with the following amenities: ";
        for (AmenityDecorator ad : amenities){
            str+=ad.getDescription() + ", ";
        }
        return str;

    }
}
