package mycontroller.strategies;

import mycontroller.datastructure.Atlas;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import mycontroller.tactics.AvoidLava;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;
import java.util.Map;


public class Expedition implements ITraversalStrategy {


    /**
     * Takes the current Node and finds the the optimal traversal to it
     * @param graph The HashMap from the Graph class
     * @return The destination the strategy wants to end up in
     */
    @Override
    public boolean findDestination(Map<Node, MapTile> graph) {

        PathFinder pathFinder = new PathFinder(graph, null, null);


        return false;
    }
}
