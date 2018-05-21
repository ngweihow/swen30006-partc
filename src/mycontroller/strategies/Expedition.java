package mycontroller.strategies;

import mycontroller.tactics.AvoidLava;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;


public class Expedition implements TraversalStrategy {


    public Boolean stratagicBehaviour(HashMap<Coordinate, MapTile> currentView, Coordinate coordinate, float health) {
        AvoidLava lava=new AvoidLava();
        if(lava.tacticalBehaviour(currentView,coordinate)) {
            return false;
        }
        return true;
    }




}
