package mycontroller.tactics;

import mycontroller.data_structure.Node;
import tiles.MapTile;
import utilities.Coordinate;


import java.util.HashMap;

public class RetrieveName implements ITraversalTactic {

    public RetrieveName() {

    }

    public boolean tacticalBehaviour(HashMap<Node, MapTile> currentView, Coordinate coordinate) {
        return false;
    }

    @Override
    public void travel() {

    }
}
