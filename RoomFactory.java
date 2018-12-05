/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: Handle the instantiation of different types of Rooms
 * Inputs: String representing the roomtype
 * Output: A concrete instance of Room
 */

public class RoomFactory {

    /**
     * Based on the input roomtype, it returns a concrete Room
     * @param type - the type of Room as a string
     * @return an instance of a concrete Room
     */
    public Room createRoom(String type){

        Room room = null;

        if(type.equals("Regular")) {       room = new RegularRoom();
        } else if(type.equals("Deluxe")) { room = new DeluxeRoom();
        } else if(type.equals("Suite")) {  room = new SuiteRoom();
        }
        return room;
    }
}
