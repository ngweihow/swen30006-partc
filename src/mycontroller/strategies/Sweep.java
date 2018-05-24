package mycontroller.strategies;

import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import tiles.MapTile;

import java.util.HashMap;
import java.util.Map;

public class Sweep implements ITraversalStrategy {

    public Sweep() {

    }

    /**
     * Takes the current Node and finds the the optimal traversal to it
     *
     * @param source The source Node from where traversing begins
     * @return The destination the strategy wants to end up in
     */
    @Override
    public boolean findDestination(Map<Node, MapTile> graph, Node source) {
        return false;
    }
}
