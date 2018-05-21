package mycontroller.tactics;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class RetrieveName implements TraversalTactic {


    public boolean tacticalBehaviour(HashMap<Coordinate, MapTile> currentView, Coordinate coordinate) {
        return false;
    }
}
