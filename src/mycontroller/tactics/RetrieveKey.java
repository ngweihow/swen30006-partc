package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.LavaTrap;
import tiles.MapTile;
import tiles.TrapTile;
import utilities.Coordinate;
import world.WorldSpatial;


import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RetrieveKey implements ITraversalTactic {
    private int currentKey;

    // Constructor
    public RetrieveKey(int currentKey) {
        this.currentKey = currentKey;
    }

    /**
     * Travel to the node where the key is
     * @return Node for the strategy to know where to travel to
     */
    @Override
    public Node travel(HashMap<Coordinate, MapTile> currentView ) {
        for (HashMap.Entry<Coordinate, MapTile> entry : currentView.entrySet()) {
            if (entry.getValue() instanceof LavaTrap) {
                LavaTrap tile = (LavaTrap) entry.getValue();
                if (tile.getKey() == currentKey) {
                    return new Node(entry.getKey());
                }
            }
        }
        return null;
    }
}
