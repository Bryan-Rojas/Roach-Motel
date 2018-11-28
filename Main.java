
public class Main {
    public static void main(String[] args){
        RoachMotel TheRoach911 = RoachMotel.getInstance();
       // TheRoach911.demo();

        TheRoach911.createRooms();
        System.out.println(TheRoach911);



        RoachColony r1 = new RoachColony("Nielsen",2,1.0,TheRoach911);
        RoachColony r2 = new RoachColony("Hansen",3,1.0,TheRoach911);

        TheRoach911.notifyObserver();

       Room room1 = TheRoach911.checkIn(r1,"deluxe", true, true, true);

        System.out.println(room1);


    }
}
