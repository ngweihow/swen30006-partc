package strategies;

import strategies.TraversalStrategy;
import tactics.TraversalTactic;
import tactics.avoidLava;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;


public class explore implements TraversalStrategy {

    @Override
    public Boolean stratagicBehaviour(HashMap<Coordinate, MapTile> currentView, Coordinate coordinate, float health) {
        avoidLava lava=new avoidLava();
        if(lava.tacticalBehaviour(currentView,coordinate)) {
            return false;
        }
        return true;
    }




}
