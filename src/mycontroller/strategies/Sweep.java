package mycontroller.strategies;

import mycontroller.MyAIController;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import mycontroller.tactics.ITraversalTactic;
import tiles.MapTile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Sweep implements ITraversalStrategy {

    // Initialising the Node and referral graph
    private Map<Node, MapTile> graph;
    private ArrayList<ITraversalTactic> tactics;

    public Sweep(Map<Node, MapTile> graph) {
        this.graph = graph;
    }

    /**
     * Get the Destination for the finish node.
     * @param graph HashMap reference for getting tiles.
     * @return Destination Node.
     */
    @Override
    public Node getDestination(Map<Node, MapTile> graph) {
        /* Use tactic lists here*/

        return null;
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
