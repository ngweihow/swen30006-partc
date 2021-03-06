/*
 * Group Number: 111
 * Armaan Dhaliwal-McLeod (837674), Wei How Ng (828472), Haohai Liu (830876)
 */
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

    /**
     * Returns the calculated Node to travel to
     * @param graph The HashMap of Nodes to MapTiles with assisting in MapTile querying
     * @return The destination Node
     */
    Node getDestination(Map<Node, MapTile> graph);

}
