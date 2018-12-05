/**
 * This class extends Room with just a cost value for the price of the price of this type of room
 * Written by
 * 11/30/2018
 */
public class DeluxeRoom extends Room {
    private double cost;

    /**
     * parameterless constructor setting cost to $75
     */
    public DeluxeRoom(){
        cost = 75.0;
    }

    /**
     * Returns the cost of the deluxe room
     * @return double cost
     */
    @Override
    public double cost(){
        return cost;
    }

}
