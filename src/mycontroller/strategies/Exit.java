package mycontroller.strategies;

import controller.CarController;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Exit implements ITraversalStrategy {
    private Map<Node, MapTile> graph;
    //private Node destination;

    public Exit(HashMap<Node, MapTile> graph) {
        this.graph = graph;
        //this.destination = getDestination(graph);
    }

    /*public Node getDestination(Map<Node, MapTile> graph) {
        for (Map.Entry<Node, MapTile> entry: graph.entrySet()) {
            if (entry.getValue().isType(MapTile.Type.FINISH)) {
                return entry.getKey();
            }
        }

        return null;
    }*/

    /**
     * Takes the current Node and finds the the optimal traversal to it
     *
     * @param source The source Node from where traversing begins
     * @return The destination the strategy wants to end up in
     */
    @Override
    public boolean findDestination(Map<Node, MapTile> graph, Node source) {
        //PathFinder pathFinder = new PathFinder(graph, source, destination);
        //Stack<Node> solution = pathFinder.findShortestPath();




        return false;
    }
}
