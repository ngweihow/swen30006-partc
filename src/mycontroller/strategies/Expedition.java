package mycontroller.strategies;

import mycontroller.data_structure.Node;
import mycontroller.tactics.AvoidLava;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;


public class Expedition implements ITraversalStrategy {


    public Boolean stratagicBehaviour(HashMap<Node, MapTile> currentView, Coordinate coordinate, float health) {

        // Use the AvoidLava tactic
        AvoidLava lava= new AvoidLava();
        if(lava.tacticalBehaviour(currentView,coordinate)) {
            return false;
        }
        return true;
    }




}
