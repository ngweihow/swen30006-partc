package strategies;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public interface TraversalStrategy {
    public Coordinate stratagicBehaviour(HashMap<Coordinate, MapTile> currentView, Coordinate coordinate);



}
