package mycontroller.strategies;

import mycontroller.datastructure.Atlas;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import mycontroller.tactics.AvoidLava;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;


public class Expedition implements ITraversalStrategy {


    /**
     * Takes the current Node and finds the the optimal traversal to it
     *
     * @param source The source Node from where traversing begins
     * @return The destination the strategy wants to end up in
     */
    @Override
    public boolean findDestination(Graph graph, Node source) {

        PathFinder pathFinder = new PathFinder(null, source, null);


        return false;
    }
}
