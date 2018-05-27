package mycontroller.datastructure;

import mycontroller.MyAIController;
import mycontroller.strategies.Exit;
import mycontroller.strategies.*;
import mycontroller.tactics.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Atlas {

    private CompositeStrategy strategyUsed;
    private StrategyFactory strategyFactory;
    private static ArrayList<String> strategyList;
    private ArrayList<ITraversalStrategy> compositionList;
    private ITraversalStrategy strategyExit ;

    // Strategies to be used for Composite Strategy
    private static final String EXPEDITION = "Expedition";
    private static final String CONQUEST = "Conquest";
    private static final String EXIT = "Exit";

    private Graph graph;
    private Driver driver;

    private static int key;

    // Static Block to populate the arraylist of strategystrings
    static {
        strategyList = new ArrayList<>(Arrays.asList(EXIT));
        key = 0;
    }

    // Constructor
    public Atlas(MyAIController controller) {
        // Initialise Graph with Singleton call
        this.graph = Graph.getGraph();

        // Make sure that each Node in the Graph is connected to their neighbours
        graph.setAllNodeNeighbours();

        // Initialise the strategy factory
        strategyFactory = new StrategyFactory();

        // Generate the strategy list to use for the composite factory
        compositionList = new ArrayList<>();
        for(String currentStrategy: strategyList) {
            // Call the Factory method to generate the composition
            compositionList.add(strategyFactory.createStrategy(graph.getGraphNodes(), currentStrategy, key));
        }

        // Initialise the composite strategy used
        strategyUsed = new CompositeStrategy(compositionList);

        //this.strategyExit = new Exit(graph.getGraphNodes());
        Stack<Node> solution = strategyUsed.findDestination(graph.getGraphNodes(), controller);

        // Get Driver
        this.driver = new Driver(controller, solution);
    }

    public Driver getDriver() {
        return driver;
    }

}
