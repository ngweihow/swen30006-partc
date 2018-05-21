package strategies;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public interface TraversalStrategy {
     Boolean stratagicBehaviour(HashMap<Coordinate, MapTile> currentView, Coordinate coordinate,float health);



}
