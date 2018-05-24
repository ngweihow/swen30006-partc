package mycontroller.strategies;

import mycontroller.MyAIController;
import mycontroller.datastructure.Atlas;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import mycontroller.tactics.AvoidLava;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Expedition implements ITraversalStrategy {


    /**
     * Takes the current Node and finds the the optimal traversal to it
     * @param graph The HashMap from the Graph class
     * @return The destination the strategy wants to end up in
     */
    @Override
    public Stack<Node> findDestination(Map<Node, MapTile> graph, MyAIController controller) {
        PathFinder pathFinder = new PathFinder(graph, null, null);
        return null;
    }
}
