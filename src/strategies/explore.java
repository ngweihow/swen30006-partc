package strategies;

import tactics.TraversalTactic;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class explore implements TraversalTactic {

    @Override
    public boolean tacticalBehaviour(HashMap<Coordinate, MapTile> currentView, Coordinate coordinate) {
        return false;
    }
}
