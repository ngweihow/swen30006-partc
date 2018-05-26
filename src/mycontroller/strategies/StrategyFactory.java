package mycontroller.strategies;

import tiles.MapTile;

import mycontroller.datastructure.Node;
import java.util.Map;

public class StrategyFactory {

    /**
     * Method to create new strategies without the need to call respective constructors
     * @param strategyName
     * @return
     */
    public ITraversalStrategy createStrategy(Map<Node, MapTile> graph, String strategyName) {

        // Return null if invalid output
        if(strategyName == null) {
            return null;
        }

        // Expedition
        // Search Map to find keys without traversing Lava
        if(strategyName.equals("Expedition")) {
            return new Expedition(graph);
        }

        // Conquest
        // Crosses Lava to search and sometimes collect keys
        if(strategyName.equals("Conquest")) {
            return new Conquest(graph);
        }

        // Sweep
        // Traverses Map to collect remaining keys only
        if(strategyName.equals("Sweep")) {
            return new Sweep(graph);
        }

        // Exit
        // Attempt to traverse to the exit of the map
        if(strategyName.equals("Exit")) {
            return new Exit(graph);
        }

        return null;

    }

}
