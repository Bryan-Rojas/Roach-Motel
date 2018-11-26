/**
 * Created by josep on 26-11-2018.
 */
public class FoodBarAmenity extends AmenityDecorator {

    private Room room;

    public FoodBarAmenity(Room room){
        this.room = room;
    }

    public String getDescription(){
     return room.getDescription() + ", Foodbar";
    }

    public double cost(){

        return 10.00 + room.cost();

    }
}
