/**
 * Extends abstract decorator class for implementation of decorator design pattern
 * Created by josep on 26-11-2018.
 */
public class SprayResistantShowerAmenity extends AmenityDecorator {

    /**
     * parameterless default constructor
     */
    public SprayResistantShowerAmenity(){}

    /**
     * @return String literal
     */
    public String getDescription(){
        return "Spray Resistant Shower";
    }

    /**
     * Cost of having spray
     * @return $25
     */
    public double cost(){

        return 25.00;

    }
}


