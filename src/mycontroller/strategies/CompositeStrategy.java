package mycontroller.strategies;

import mycontroller.MyAIController;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import tiles.MapTile;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class CompositeStrategy implements ITraversalStrategy {

    // ArrayList of the combination of strategies used
    ArrayList<ITraversalStrategy> strategiesOrder = new ArrayList<>();


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
        return null;
    }

    // Getters and Setters

    public ArrayList<ITraversalStrategy> getStrategiesOrder() {
        return strategiesOrder;
    }

    public void setStrategiesOrder(ArrayList<ITraversalStrategy> strategiesOrder) {
        this.strategiesOrder = strategiesOrder;
    }
}
