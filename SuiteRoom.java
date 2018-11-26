
public class SuiteRoom extends Room {

    private double cost;

    public SuiteRoom(){
        cost = 100.0;
    }

    @Override
    public double cost(){
        return cost;
    }

}
