/*
 * Group Number: 111
 * Armaan Dhaliwal-McLeod (837674), Wei How Ng (828472), Haohai Liu (830876)
 */
package mycontroller.tactics;

public class TacticFactory {
    private static final String HEAL = "Heal";
    private static final String RETRIEVE_KEY = "RetrieveKey";
    private static final String AVOID_LAVA = "AvoidLava";

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
        if(tacticName.equals(HEAL)) {
            return new Heal();
        }

        // RetrieveKey tactic
        else if(tacticName.equals(RETRIEVE_KEY)) {
            return new RetrieveKey(currentKey);
        }

        // AvoidLava Tactic
        else if(tacticName.equals(AVOID_LAVA)) {
            return new AvoidLava();
        }

        return null;
    }
}
