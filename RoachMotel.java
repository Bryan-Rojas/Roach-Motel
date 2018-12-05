
import java.util.*;

public class RoachMotel implements Subject{

    private static RoachMotel RM;
    private Map<Room, Boolean> RM_map;
    private boolean vacancy;
    private ArrayList<Observer> waitList;

    /**
     * Private constructor to ensure only one instance (singleton)
     */
    private RoachMotel(){
        vacancy = true;
        waitList = new ArrayList<>();
        RM_map = new HashMap<Room,Boolean>();
    }

    /**
     *
     * @return the only Roach Motel instance
     */
    public static RoachMotel getInstance(){
        if(RM == null){
            RM = new RoachMotel();
        }
        return RM;
    }

    /**
     * Vacancy sign
     */
    public void vacancy(){
        vacancy = true;
    }

    /**
     * NoVacancy sign
     */
    public void noVacancy(){vacancy = false;}

    /**
     * Creating rooms and places them in the HashMap as a Regular room and vacant as a standard
     * @param numberOfRooms - takes the wished number of rooms for the Roach Motel
     */
    public void createRooms(int numberOfRooms){
        for (int i = 1; i<numberOfRooms; i++) {
            RM_map.put(new RegularRoom(), true);
        }

    }

    /**
     * Registers observers (for the wait list)
     * @param o - takes an observer (Roach colony)
     */
    @Override
    public void registerObserver(Observer o) {
        waitList.add(o);
    }

    /**
     * Removes observers (from the wait list)
     * @param o - takes an observer (Roach colony)
     */
    @Override
    public void removeObserver(Observer o) {

        int i = waitList.indexOf(o);
        if (i >=0 ){
            waitList.remove(i);
        }
    }

    /**
     * Notifies observers on the wait list
     */
    @Override
    public void notifyObserver() {
        for (Observer o : waitList){
            o.update();
        }
    }

    /**
     * Check in method
     * @param rc - The particular roach colony
     * @param roomType - The wished room type
     * @param foodBar - if wanted (true/false)
     * @param foodbarAndRefill - if wanted (true/false)
     * @param spa - if wanted (true/false)
     * @param shower - if wanted (true/false)
     */
    public void checkIn(RoachColony rc, String roomType, boolean foodBar, boolean foodbarAndRefill, boolean spa, boolean shower){

        int nonVacantRooms = 0;
        Room room;

        //Checks for a vacant room and removes it from the Hash map
        for(Room key : RM_map.keySet()) {
            if(RM_map.get(key)) {
                RM_map.remove(key);
                break;
            } else {
                nonVacantRooms++;
            }
        }

        //If there are no more vacant rooms, it prints a message
        //Otherwise the room is saved in the map again as the wished room type and with the wished amenities
        if(nonVacantRooms == RM_map.size()) {
            System.out.println("There is no more vacant rooms\n" + rc.getName() + " is added to the waitlist");
            noVacancy();
            registerObserver(rc);

        } else {
            switch (roomType){
                case "deluxe" :
                    room = new DeluxeRoom();
                    break;

                case "suite" :
                    room = new SuiteRoom();
                    break;
                                            //If the wished type of the room is not deluxe or suite, it becomes a regular room
                default:
                    room = new RegularRoom();
                    break;
            }

            //If foodBar refill is chosen, then the room is added a foodbar with refill is added
            if((foodBar && foodbarAndRefill) || foodbarAndRefill) {
                FoodBarAmenity f = new FoodBarAmenity();
                f.AddRefill();
                room.addAmenity(f);
            } else if(foodBar) {                //Else the foodbar is added, only
                room.addAmenity(new FoodBarAmenity());
            }

            if (spa){
                room.addAmenity(new SpaAmenity());
            }

            if (shower){
                room.addAmenity(new SprayResistantShowerAmenity());
            }

            //The room is added and vacancy is now false
            RM_map.put(room, false);

            //The roach colony sets the room
            rc.setRoom(room);

            System.out.println(rc.getName() + " checked in to a room.");
        }
    }

    /**
     * Check out method
     * @param colony - Takes the particular roach colony
     * @param days - Takes the amount of days the roach colony has stayed in the motel
     */
    public void checkOut(RoachColony colony, int days){

        System.out.println("Roach colony " + colony + " is checking out:");

        //Retrieves the particular and saves it as vacant
        Room colonyRoom = colony.getRoom();
        RM_map.put(colonyRoom, true);

        //Calculates the the cost of the room and amenities times the number of days
        double cost = (colonyRoom.cost() + colonyRoom.getAmenityCost()) * days;

        System.out.println("The totalt price for the room is: $" +  cost + ". \n The Colony has been checked out now. ");

        if(vacancy == false) {
            vacancy();
            notifyObserver();
            waitList.clear();
            System.out.println("The wait list has been cleared.");
        }




    }


    public void sprayParty(RoachColony colony) {
        System.out.println("Hotel sprays with insecticide");

        //get amenities from the room of the colony
        Set<AmenityDecorator> amenities = colony.getRoom().GetAmenities();

        //loop through amenities
        for(AmenityDecorator a : amenities) {
            //if amenities contains an instance of Spray Resistant Shower
            if(a instanceof SprayResistantShowerAmenity) {
                System.out.println("Room has Spray Resistant Shower - colony is reduced by 25%");

                //reduce population by 25%, round up because roaches lives even if they are in pieces
                colony.setPopulation((int) Math.ceil(colony.getPopulation() * 0.75));
                return;
            }
        }

        System.out.println("No Spray Resistant Shower - colony is reduced by 50%");
        //if there is no Spray Resistant Shower - reduce colony by 50%
        colony.setPopulation((int) Math.ceil(colony.getPopulation() * 0.5));
    }


    @Override
    public String toString() {
        String str = "Welcome to the roach motel!";

        if(vacancy) {
            str += "\nVacancy! The following rooms are available: ";
            for(Room room : RM_map.keySet()) {
                if (RM_map.get(room) == true){

                    str += room + ", ";
                }
            }

        } else {
            str += "\nNo Vacancy! The waitlist for a room is: " + waitList;
        }

        return str;
    }
}
