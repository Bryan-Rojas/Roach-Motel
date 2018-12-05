/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class RegularRoom extends Room {

    private double cost;

    public RegularRoom(){
        cost = 50.0;
    }

    @Override
    public double cost() {
        return cost;
    }

}
