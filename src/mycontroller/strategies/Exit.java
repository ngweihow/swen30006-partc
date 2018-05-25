package mycontroller.strategies;


import mycontroller.MyAIController;
import mycontroller.datastructure.Node;
import mycontroller.tactics.ITraversalTactic;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Exit implements ITraversalStrategy {

    // Initialising the Node and referral graph
    private Map<Node, MapTile> graph;
    private Node destination;
    private ArrayList<ITraversalTactic> tactics;

    public Exit(Map<Node, MapTile> graph) {
        this.graph = graph;
        this.destination = getDestination(graph);
    }

    /**
     * Get the Destination for the finish node.
     * @param graph HashMap reference for getting tiles.
     * @return Destination Node.
     */
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
     * @return The destination the strategy wants to end up in
     */
    @Override
    public Stack<Node> findDestination(Map<Node, MapTile> graph, MyAIController controller) {
        PathFinder pathFinder = new PathFinder(graph);
        Stack<Node> solution = pathFinder.findShortestPath(new Node(new Coordinate(controller.getPosition())), destination);
        return solution;
    }
}
