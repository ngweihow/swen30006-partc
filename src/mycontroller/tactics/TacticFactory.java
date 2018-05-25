package mycontroller.tactics;

public class TacticFactory {

    /**
     * Method to create tactics used for immediate traversal
     * @param tacticName
     * @return a new Tactic object
     */
    public static ITraversalTactic createTactic(String tacticName) {


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
            return new RetrieveKey(null, null, 1);
        }

        // AvoidLava Tactic
        else if(tacticName.equals("AvoidLava")) {
            return new AvoidLava(null);
        }


        return null;
    }
}
