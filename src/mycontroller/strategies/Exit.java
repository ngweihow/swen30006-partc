package mycontroller.strategies;


import mycontroller.MyAIController;
import mycontroller.datastructure.Node;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.Map;
import java.util.Stack;

public class Exit implements ITraversalStrategy {
    private Map<Node, MapTile> graph;
    private Node destination;

    public Exit(Map<Node, MapTile> graph) {
        this.graph = graph;
        this.destination = getDestination(graph);


    }

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
        PathFinder pathFinder = new PathFinder(graph, new Node(new Coordinate(controller.getPosition())), destination);
        Stack<Node> solution = pathFinder.findShortestPath();
        return solution;
    }
}
