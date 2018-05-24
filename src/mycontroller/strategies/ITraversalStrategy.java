package mycontroller.strategies;

import mycontroller.MyAIController;
import mycontroller.datastructure.Node;
import tiles.MapTile;

import java.util.Map;
import java.util.Stack;

public interface ITraversalStrategy {

    /**
     * Takes the current Node and finds the the optimal traversal to it
     * @param graph The graph in which the nodes are contained in
     * @return The destination the strategy wants to end up in
     */
    Stack<Node> findDestination(Map<Node, MapTile> graph, MyAIController controller);


}
