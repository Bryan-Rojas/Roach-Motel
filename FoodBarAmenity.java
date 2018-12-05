/**
 * Concrete Class extending abstract decorator class for implementation of decorator design pattern
 * Created by josep on 26-11-2018.
 */
public class FoodBarAmenity extends AmenityDecorator {

    private boolean refill;

    /**
     * constructor setting refil to false
     */
    public FoodBarAmenity(){
        refill = false;
    }

    /**
     * returns food bar as the description
     * @return String foodbar
     */
    public String getDescription(){
        return "Foodbar";
    }

    /**
     * Calculates the cost of the food bar depending on its usage
     * @return 15 or 10
     */
    public double cost(){
        if(refill) {
            return 15.00;
        } else {
            return 10.00;
        }
    }

    /**
     * changes class variable to true
     * @param none
     */
    public void AddRefill() {
        refill = true;
    }
}
