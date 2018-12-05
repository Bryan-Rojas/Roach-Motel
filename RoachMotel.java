
import java.util.*;

public class RoachMotel implements Subject{
    private static RoachMotel RM;
    private Map<Room, Boolean> RM_map;
    private boolean vacancy;
    private ArrayList<Observer> waitList;

    private RoachMotel(){
        vacancy = true;
        waitList = new ArrayList<>();
        RM_map = new HashMap<Room,Boolean>();
    }

    public static RoachMotel getInstance(){
        if(RM == null){
            RM = new RoachMotel();
        }
        return RM;
    }

    public void vacancySwitch(){
        vacancy = !vacancy;
    }


    public void createRooms(int numberOfRooms){
        for (int i = 1; i<numberOfRooms; i++) {
            RM_map.put(new RegularRoom(), true);
        }

    }

    @Override
    public void registerObserver(Observer o) {
        waitList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

        int i = waitList.indexOf(o);
        if (i >=0 ){
            waitList.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : waitList){
            o.update();
        }

    }


    public void checkIn(RoachColony rc, String roomType, boolean foodBar, boolean foodbarAndRefill, boolean spa, boolean shower){

        int nonVacantRooms = 0;
        Room room;

        for(Room key : RM_map.keySet()) {
            if(RM_map.get(key)) {
                room = key;
                RM_map.remove(key);
                break;
            } else {
                nonVacantRooms++;
            }
        }

        if(nonVacantRooms == RM_map.size()) {
            System.out.println("There is no more vacant rooms\n" + rc.getName() + " is added to the waitlist");
            vacancySwitch();
            registerObserver(rc);

        } else {
            switch (roomType){
                case "deluxe" :
                    room = new DeluxeRoom();
                    break;

                case "suite" :
                    room = new SuiteRoom();
                    break;

                default:
                    room = new RegularRoom();
                    break;
            }

            if((foodBar && foodbarAndRefill) || foodbarAndRefill) {
                FoodBarAmenity f = new FoodBarAmenity();
                f.AddRefill();
                room.addAmenity(f);
            } else if(foodBar) {
                room.addAmenity(new FoodBarAmenity());
            }

            if (spa){
                room.addAmenity(new SpaAmenity());
            }

            if (shower){
                room.addAmenity(new SprayResistantShowerAmenity());
            }

            RM_map.put(room, false);

            rc.setRoom(room);

            System.out.println(rc.getName() + " checked in to a room");
        }
    }


    public double checkOut(RoachColony colony, int days){

        System.out.println("Roach colony " + colony + " has checked out");

        Room colonyRoom = colony.getRoom();
        RM_map.put(colonyRoom, true);

        if(!vacancy) {
            vacancySwitch();
            notifyObserver();
            waitList.clear();
        }

        double cost = (colonyRoom.cost() + colonyRoom.getAmenityCost()) * days;

        return cost;
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
            str += "\nVacancy! The following rooms are available: " + RM_map;
        } else {
            str += "\nNo Vacancy! The waitlist for a room is: " + waitList;
        }

        return str;
    }
}
