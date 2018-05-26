package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.MapTile;

import java.util.Map;

public class TacticFactory {

    public TacticFactory() {

    }

    /**
     * Method to create tactics used for immediate traversal
     * @param tacticName
     * @return a new Tactic object
     */
    public ITraversalTactic createTactic(String tacticName, int currentKey) {
        // Return null if invalid output
        if(tacticName == null) {
            return null;
        }

        // Heal tactic
        if(tacticName.equals("Heal")) {
            return new Heal();
        }

        // RetrieveKey tactic
        else if(tacticName.equals("RetrieveKey")) {
            return new RetrieveKey(currentKey);
        }

        // AvoidLava Tactic
        else if(tacticName.equals("AvoidLava")) {
            return new AvoidLava();
        }

        return null;
    }
}
