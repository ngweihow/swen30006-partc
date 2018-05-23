package mycontroller.tactics;

import mycontroller.datastructure.Node;
import world.WorldSpatial;


import java.util.ArrayList;

public class AvoidLava implements ITraversalTactic {

    private ArrayList<Node> radius;
    private Node source;
    private static final int RANGE = 2;

    public AvoidLava(Node currentNode) {
        this.source = currentNode;
    }

    /**
     * Scan the current node and returns the direction of which should be travelled
     * @return The enum variable of a Direction to travel
     */
    public WorldSpatial.Direction scanForLava() {



        return null;
    }

    public int seekDirection() {
        return 0;
    }




    @Override
    public void travel() {

    }
}
