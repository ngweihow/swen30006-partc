/*
 * Group Number: 111
 * Armaan Dhaliwal-McLeod (837674), Wei How Ng (828472), Haohai Liu (830876)
 */
package mycontroller.strategies;


import mycontroller.MyAIController;
import mycontroller.datastructure.Node;
import mycontroller.tactics.AvoidLava;
import mycontroller.tactics.ITraversalTactic;
import mycontroller.tactics.TacticFactory;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class Exit implements ITraversalStrategy {
    // Initialising the Node and referral graph
    private Map<Node, MapTile> graph;
    private static ArrayList<String> tacticsList;
    private ArrayList<ITraversalTactic> tactics;
    private TacticFactory tacticFactory;

    private static final String AVOID_LAVA = "AvoidLava";

    // Initialising the arraylist of tactics
    static {
        tacticsList =  new ArrayList<>(Arrays.asList(AVOID_LAVA));
    }

    public Exit(Map<Node, MapTile> graph, int key) {
        this.graph = graph;
        this.tacticFactory = new TacticFactory();

        tactics = new ArrayList<>();
        for (String tactic : tacticsList) {
            tactics.add(tacticFactory.createTactic(tactic, key));
        }
    }

    /**
     * Get the Destination for the finish node.
     * @param graph HashMap reference for getting tiles.
     * @return Destination Node.
     */
    @Override
    public Node getDestination(Map<Node, MapTile> graph) {
        for (Map.Entry<Node, MapTile> entry: graph.entrySet()) {
            if (entry.getValue().isType(MapTile.Type.FINISH)) {
                return entry.getKey();
            }
        }

        return null;
    }

    /**
     * Takes the current Node and finds the the optimal traversal to it
     *
     * @param graph The HashMap from the Graph class
     * @return The destination the strategy wants to end up in getDestination(graph)
     */
    @Override
    public Stack<Node> findDestination(Map<Node, MapTile> graph, MyAIController controller) {
        PathFinder pathFinder = new PathFinder(graph);
        Node source = new Node(new Coordinate(controller.getPosition()));
        Node destination = getDestination(graph);
        Stack<Node> solution = pathFinder.findShortestPath(source, destination);
        return solution;
    }
}
