/**
 * Created by josep on 26-11-2018.
 */

public class SpaAmenity extends AmenityDecorator {

    private Room room;

    public SpaAmenity(Room room){
        this.room = room;
    }

    public String getDescription(){
        return room.getDescription() + ", Spa";
    }

    public double cost(){

        return 20.00 + room.cost();

    }
}

