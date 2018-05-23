package mycontroller.strategies;

import mycontroller.datastructure.Node;

public class Sweep implements ITraversalStrategy {

    public Sweep() {

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
