/**
 * Roach Colony class implements observer class for observer design pattern
 * Has functions: getters and setters, throw party, update, display, and overwritten toString
 * Created by josep on 28-11-2018.
 */
public class RoachColony implements Observer {

    private String name;
    private int population;
    private double growthRate;
    private Subject motel;
    private Room room;

    /**
     * constructor for RoachColony class
     * @param name
     * @param population
     * @param growthRate
     * @param motel
     */
    public RoachColony(String name, int population, double growthRate, Subject motel){
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
        this.motel = motel;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public Room getRoom() {
        return room;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Function increases population by the growth rate and reduces population
     * depending on the room and if it has sprayers
     * @param none
     * @return none
     */
    public void throwParty() {
        System.out.println(name + " throws a PARTY!!!!");
        System.out.print("Population increases from " + population);

        population += population * growthRate;

        System.out.println(" to " + population);

        ((RoachMotel) motel).sprayParty(this);

        System.out.println("After being sprayed, population is reduced to " + population);
    }

    /**
     * calls display function
     */
    @Override
    public void update() {
        display();
    }

    /**
     * outputs to console if a roach colony is notified of the vacancy
     */
    public void display(){
        System.out.println("The Roach Colony " + name + " has received a notification of vacancy.");
    }

    @Override
    public String toString() {
        return "This is a Roach Colony " + name + ", with a population of: " + population;
    }
}

