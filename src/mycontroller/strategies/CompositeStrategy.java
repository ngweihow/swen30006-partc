package mycontroller.strategies;

import mycontroller.MyAIController;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import tiles.MapTile;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class CompositeStrategy implements ITraversalStrategy {

    // ArrayList of the combination of strategies used
    ArrayList<ITraversalStrategy> strategiesOrder;


    public CompositeStrategy(ArrayList<ITraversalStrategy> strategiesOrder) {
        this.strategiesOrder = strategiesOrder;
    }

    /**
     * Takes the current Node and finds the the optimal traversal to it
     * @param graph The HashMap from the Graph class
     * @return The destination the strategy wants to end up in
     */
    @Override
    public Stack<Node> findDestination(Map<Node, MapTile> graph, MyAIController controller) {
        Stack<Node> solution = null;

        for (ITraversalStrategy strategy : strategiesOrder) {
            solution = strategy.findDestination(graph, controller);

        }

        return solution;
    }

    // Getters and Setters

    public ArrayList<ITraversalStrategy> getStrategiesOrder() {
        return strategiesOrder;
    }

    /**
     * Get the Destination for the finish node.
     * @param graph HashMap reference for getting tiles.
     * @return Destination Node.
     */
    public Node getDestination(Map<Node, MapTile> graph) {
        /* Use tactic lists here*/

        return null;
    }

    public void setStrategiesOrder(ArrayList<ITraversalStrategy> strategiesOrder) {
        this.strategiesOrder = strategiesOrder;
    }
}
