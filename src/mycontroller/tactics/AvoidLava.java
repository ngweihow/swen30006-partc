package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.LavaTrap;
import tiles.MapTile;
import utilities.Coordinate;
import world.WorldSpatial;


import java.util.*;

public class AvoidLava implements ITraversalTactic {

    /**
     * Returns the next node where to travel to
     * @return Next node to travel to
     */
    @Override
    public Node travel(HashMap<Coordinate, MapTile> currentView) {
        for (HashMap.Entry<Coordinate, MapTile> entry : currentView.entrySet()) {
            if (!(entry.getValue() instanceof LavaTrap)) {
                return new Node(entry.getKey());
            }
        }
        return null;
    }
}
