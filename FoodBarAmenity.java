/**
 * Created by josep on 26-11-2018.
 */
public class FoodBarAmenity extends AmenityDecorator {

    private boolean refill;

    public FoodBarAmenity(){
        refill = false;
    }

    public String getDescription(){
        return "Foodbar";
    }

    public double cost(){
        if(refill) {
            return 15.00;
        } else {
            return 10.00;
        }
    }

    public void AddRefill() {
        refill = true;
    }
}
