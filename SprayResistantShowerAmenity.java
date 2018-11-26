/**
 * Created by josep on 26-11-2018.
 */
public class SprayResistantShowerAmenity extends AmenityDecorator {

    private Room room;

    public SprayResistantShowerAmenity(Room room){
        this.room = room;
    }

    public String getDescription(){
        return room.getDescription() + ", Spray Resistant Shower";
    }

    public double cost(){

        return 25.00 + room.cost();

    }
}


