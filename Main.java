/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: It's our main class and tester to test functionality of all our classes. Everything
 * hard coded and is a simulation of our Roach-Motel.
 * Inputs: N/A 
 * Output: Sample output to show functionaility of our Roach-Motel named "The Roach 911"
*/

public class Main {
    public static void main(String[] args){
        RoachMotel TheRoach911 = RoachMotel.getInstance();

        TheRoach911.createRooms(6);
        System.out.println(TheRoach911);


        RoachColony r1 = new RoachColony("Nielsen",2,1.0,TheRoach911);
        RoachColony r2 = new RoachColony("Hansen",3,1.2,TheRoach911);
        RoachColony r3 = new RoachColony("Skywalker",4,1.3,TheRoach911);
        RoachColony r4 = new RoachColony("Gremlins",2,2.0,TheRoach911);
        RoachColony r5 = new RoachColony("Jensen",10,0.8,TheRoach911);
        RoachColony r6 = new RoachColony("Vader",5,1.0,TheRoach911);

        TheRoach911.notifyObserver();

        TheRoach911.checkIn(r1,"deluxe", true, false, true, true);
        TheRoach911.checkIn(r2,"regular", false, true, false, false);
        TheRoach911.checkIn(r3,"suite", true, true, false, false);
        TheRoach911.checkIn(r4,"deluxe", false, true, true, true);
        TheRoach911.checkIn(r5,"suite", false, false, false, false);
        System.out.println();
        TheRoach911.checkIn(r6,"regular", true, true, true, true);

        System.out.println();
        
        System.out.println(TheRoach911);

        System.out.println();
        System.out.println("Time to check out!");
        TheRoach911.checkOut(r1, 3);

        System.out.println();
        System.out.println(TheRoach911);

        r2.throwParty();
        System.out.println();
        r5.throwParty();
        System.out.println();

    }
}
