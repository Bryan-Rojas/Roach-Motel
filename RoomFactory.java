/**
 * Created by josep on 26-11-2018.
 */
public class RoomFactory {

    public Room createRoom(String type){

        Room room = null;

        if(type.equals("Regular")) {
            room = new RegularRoom();
        } else if(type.equals("Deluxe")) {
            room = new DeluxeRoom();
        } else if(type.equals("Suite")) {
            room = new SuiteRoom();
        }

        return room;
    }

}
