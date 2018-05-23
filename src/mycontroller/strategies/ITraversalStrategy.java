package mycontroller.strategies;

import mycontroller.datastructure.Node;

public interface ITraversalStrategy {

    /**
     * Takes the current Node and finds the the optimal traversal to it
     * @param source The source Node from where traversing begins
     * @return The destination the strategy wants to end up in
     */
    Node findDestination(Node source);


}
