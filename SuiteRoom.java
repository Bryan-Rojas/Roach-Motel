/**
 * This class extends basic room with an updated cost value
 * Written by
 * 11/25/2018
 */
public class SuiteRoom extends Room {

    private double cost;

    /**
     * constructor
     * @param none
     */
    public SuiteRoom(){
        cost = 100.0;
    }

    /**
     * @return cost
     */
    @Override
    public double cost(){
        return cost;
    }

}
