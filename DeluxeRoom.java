/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: This class describes a concrete Room of type Deluxe, with a description and cost
 * Inputs:
 * Output: string description, and cost
 */

public class DeluxeRoom extends Room {

    private double cost; //the cost of a Deluxe Room

    /**
     * Default constructor setting cost to 75
     */
    public DeluxeRoom(){
        cost = 75.0;
    }

    /**
     * @return string representation of a Deluxe Room
     */
    @Override
    public String getDescription() { return "Deluxe room"; }

    /**
     * @return cost of a Deluxe Room
     */
    @Override
    public double cost(){
        return cost;
    }

}
