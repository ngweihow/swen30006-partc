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

        // RetrieveName tactic
        else if(tacticName.equals("RetrieveName")) {
            return new RetrieveName();
        }

        // AvoidLava Tactic
        else if(tacticName.equals("AvoidLava")) {
            return new AvoidLava();
        }


        return null;
    }
}
