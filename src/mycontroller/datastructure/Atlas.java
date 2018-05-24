package mycontroller.datastructure;

import mycontroller.MyAIController;
import mycontroller.strategies.Exit;
import mycontroller.strategies.*;
import mycontroller.tactics.Driver;

import java.util.ArrayList;
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
    private static final String SWEEP = "Sweep";
    private static final String EXIT = "Exit";

    private Driver driver;

    // Static Block to populate the arraylist of strategystrings
    static {
        strategyList = new ArrayList<>();
        strategyList.add(EXPEDITION);
        strategyList.add(CONQUEST);
        strategyList.add(SWEEP);
        strategyList.add(EXIT);
    }

    // Constructor
    public Atlas() {

    }

    /**
     * Initialises an Atlas where the one Simulation is run
     */
    public void initAtlas(MyAIController controller) {


        // Initialise Graph with Singleton call
        Graph graph = Graph.getGraph();

        // Make sure that each Node in the Graph is connected to their neighbours
        graph.setAllNodeNeighbours();

        /*
        // Initialise the strategy factory
        strategyFactory = new StrategyFactory();

        // Generate the strategy list to use for the composite factory
        for(String currentStrategy: strategyList) {
            // Call the Factory method to generate the composition
            compositionList.add(strategyFactory.createStrategy(currentStrategy));
        }

        // Initialise the composite strategy used
        strategyUsed = new CompositeStrategy(compositionList);
        */

        strategyExit = new Exit(graph.getGraphNodes());
        Stack<Node> solution = strategyExit.findDestination(graph.getGraphNodes(), controller);

        // Get Driver
        Driver driver = new Driver(controller, solution);

    }



}
