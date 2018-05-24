package mycontroller.strategies;

import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;

public interface ITraversalStrategy {

    /**
     * Takes the current Node and finds the the optimal traversal to it
     * @param graph The graph in which the nodes are contained in
     * @param source The source Node from where traversing begins
     * @return The destination the strategy wants to end up in
     */
    boolean findDestination(Graph graph, Node source);


}
