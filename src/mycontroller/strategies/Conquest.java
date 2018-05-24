package mycontroller.strategies;

import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;

public class Conquest implements ITraversalStrategy {

    public Conquest() {

    }

    /**
     * Takes the current Node and finds the the optimal traversal to it
     *
     * @param source The source Node from where traversing begins
     * @return The destination the strategy wants to end up in
     */
    @Override
    public boolean findDestination(Graph graph, Node source) {

        return false;
    }
}
