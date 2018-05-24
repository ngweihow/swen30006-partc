package mycontroller.strategies;

import mycontroller.MyAIController;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import tiles.MapTile;

import java.util.Map;
import java.util.Stack;

public class Conquest implements ITraversalStrategy {

    public Conquest() {

    }

    /**
     * Takes the current Node and finds the the optimal traversal to it
     *
     * @param graph The HashMap from the Graph class
     * @return The destination the strategy wants to end up in
     */
    @Override
    public Stack<Node> findDestination(Map<Node, MapTile> graph, MyAIController controller) {

        return null;
    }
}
