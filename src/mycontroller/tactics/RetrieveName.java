package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.MapTile;
import utilities.Coordinate;


import java.util.HashMap;

public class RetrieveName implements ITraversalTactic {

    public RetrieveName() {

    }

    public boolean tacticalBehaviour(HashMap<Node, MapTile> currentView, Node node) {
        return false;
    }

    @Override
    public Node travel() {

        return null;
    }
}
