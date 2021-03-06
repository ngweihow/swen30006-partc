/*
 * Group Number: 111
 * Armaan Dhaliwal-McLeod (837674), Wei How Ng (828472), Haohai Liu (830876)
 */
package mycontroller.strategies;

import mycontroller.MyAIController;
import mycontroller.datastructure.Atlas;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import mycontroller.tactics.AvoidLava;
import mycontroller.tactics.ITraversalTactic;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Expedition implements ITraversalStrategy {

    // Initialising the Node and referral graph
    private Map<Node, MapTile> graph;
    private ArrayList<ITraversalTactic> tactics;


    public Expedition(Map<Node, MapTile> graph) {
        this.graph = graph;
        this.tactics = new ArrayList<>();
    }


    /**
     * Get the Destination for the finish node.
     * @param graph HashMap reference for getting tiles.
     * @return Destination Node.
     */
    public Node getDestination(Map<Node, MapTile> graph) {
        /* Use tactic lists here*/

        return null;
    }

    /**
     * Takes the current Node and finds the the optimal traversal to it
     * @param graph The HashMap from the Graph class
     * @return The destination the strategy wants to end up in
     */
    @Override
    public Stack<Node> findDestination(Map<Node, MapTile> graph, MyAIController controller) {
        PathFinder pathFinder = new PathFinder(graph);
        return null;
    }
}
