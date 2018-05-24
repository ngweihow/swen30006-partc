package mycontroller.strategies;

import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import tiles.MapTile;

import java.util.ArrayList;
import java.util.Map;

public class CompositeStrategy implements ITraversalStrategy {

    // ArrayList of the combination of strategies used
    ArrayList<ITraversalStrategy> strategiesOrder = new ArrayList<>();


    public CompositeStrategy(ArrayList<ITraversalStrategy> strategiesOrder) {
        this.strategiesOrder = strategiesOrder;
    }

    /**
     * Takes the current Node and finds the the optimal traversal to it
     * @param source The source Node from where traversing begins
     * @return The destination the strategy wants to end up in
     */
    @Override
    public boolean findDestination(Map<Node, MapTile> graph, Node source) {
        return false;
    }

    // Getters and Setters

    public ArrayList<ITraversalStrategy> getStrategiesOrder() {
        return strategiesOrder;
    }

    public void setStrategiesOrder(ArrayList<ITraversalStrategy> strategiesOrder) {
        this.strategiesOrder = strategiesOrder;
    }
}
