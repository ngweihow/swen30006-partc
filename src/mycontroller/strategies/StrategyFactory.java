package mycontroller.strategies;

public class StrategyFactory {

    /**
     * Method to create new strategies without the need to call respective constructors
     * @param strategyName
     * @return
     */
    public static ITraversalStrategy createStrategy(String strategyName) {

        // Return null if invalid output
        if(strategyName == null) {
            return null;
        }

        // Expedition
        // Search Map to find keys without traversing Lava
        if(strategyName.equals("Expedition")) {
            return new Expedition();
        }

        // Conquest
        // Crosses Lava to search and sometimes collect keys
        if(strategyName.equals("Conquest")) {
            return new Conquest();
        }

        // Sweep
        // Traverses Map to collect remaining keys only
        if(strategyName.equals("Sweep")) {
            return new Sweep();
        }

        // Exit
        // Attempt to traverse to the exit of the map
        if(strategyName.equals("Exit")) {
            return new Exit();
        }

        return null;

    }

}
