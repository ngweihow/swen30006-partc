package mycontroller.tactics;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public interface TraversalTactic{
    public boolean tacticalBehaviour(HashMap<Coordinate, MapTile> currentView,Coordinate coordinate);
}
