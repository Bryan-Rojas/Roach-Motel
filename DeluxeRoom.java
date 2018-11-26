
public class DeluxeRoom extends Room {
    private double cost;

    public DeluxeRoom(){
        cost = 75.0;
    }

    @Override
    public double cost(){
        return cost;
    }

}
