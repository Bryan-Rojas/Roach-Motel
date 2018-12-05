/**
 * Class used to set up the number and types of rooms contained in the roach motel
 * Created by josep on 26-11-2018.
 */
public class RoomFactory {

    /**
     * Given a String, a certain type of room will be created
     * @param String type
     * @return Room room
     */
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
