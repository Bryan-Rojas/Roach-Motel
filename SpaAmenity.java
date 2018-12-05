/**
 * Concrete class extending abstract decorator class for implementation of decorator design pattern
 * Created by josep on 26-11-2018.
 */

public class SpaAmenity extends AmenityDecorator {

    /**
     * parameterless constructor
     */
    public SpaAmenity(){}

    /**
     *
     * @return String literal
     */
    public String getDescription(){
        return "Spa";
    }

    /**
     * cost of having a spa
     * @return $20
     */
    public double cost(){
        return 20.00;
    }
}

