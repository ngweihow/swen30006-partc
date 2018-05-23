package mycontroller.strategies;

import mycontroller.datastructure.Node;
import utilities.Coordinate;

import java.util.ArrayList;

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
    public Node findDestination(Node source) {
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
