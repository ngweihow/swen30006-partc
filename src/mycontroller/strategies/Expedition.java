package mycontroller.strategies;

import mycontroller.datastructure.Node;
import mycontroller.tactics.AvoidLava;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;


public class Expedition implements ITraversalStrategy {


    public Boolean stratagicBehaviour(HashMap<Node, MapTile> currentView, Coordinate coordinate, float health) {

        // Use the AvoidLava tactic
        AvoidLava lava= new AvoidLava();
        if(lava.tacticalBehaviour(currentView,coordinate)) {
            return false;
        }
        return true;
    }


    /**
     * Takes the current Node and finds the the optimal traversal to it
     *
     * @param source The source Node from where traversing begins
     * @return The destination the strategy wants to end up in
     */
    @Override
    public Node findDestination(Node source) {
        return null;
    }
}
