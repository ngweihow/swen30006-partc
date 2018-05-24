package mycontroller.datastructure;

import mycontroller.strategies.*;
import tiles.MapTile;
import utilities.Coordinate;
import world.World;

import java.util.ArrayList;
import java.util.HashMap;

public class Atlas {

    private CompositeStrategy strategyUsed;
    private StrategyFactory strategyFactory;
    private static ArrayList<String> strategyList;
    private ArrayList<ITraversalStrategy> compositionList;

    // Strategies to be used for Composite Strategy
    private static final String EXPEDITION = "Expedition";
    private static final String CONQUEST = "Conquest";
    private static final String SWEEP = "Sweep";
    private static final String EXIT = "Exit";

    // Static Block to populate the arraylist of strategystrings
    static {
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
    public void initAtlas() {


        // Initialise Graph with Singleton call
        Graph graph = Graph.createGraph();

        // Make sure that each Node in the Graph is connected to their neighbours
        graph.setAllNodeNeighbours();

        // Initialise the strategy factory
        strategyFactory = new StrategyFactory();

        // Generate the strategy list to use for the composite factory
        for(String currentStrategy: strategyList) {
            // Call the Factory method to generate the composition
            compositionList.add(strategyFactory.createStrategy(currentStrategy));
        }

        // Initialise the composite strategy used
        strategyUsed = new CompositeStrategy(compositionList);



    }



}
