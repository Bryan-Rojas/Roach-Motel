/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Extention of basic class room with addition information
 * @author Bryan
 * 11/25/2018
 */
public class RegularRoom extends Room {

    private double cost;

    /**
     * parameterless constructor
     * setting cost to $50
     */
    public RegularRoom(){
        cost = 50.0;
    }

    /**
     * @return cost
     */
    @Override
    public double cost() {
        return cost;
    }

}
