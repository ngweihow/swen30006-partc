package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class Heal implements ITraversalTactic {

    public Heal() {

    }

    public boolean tacticalBehaviour(HashMap<Node, MapTile> currentView, Node node) {
        return false;
    }

    @Override
    public Node travel() {

        return null;
    }


}
