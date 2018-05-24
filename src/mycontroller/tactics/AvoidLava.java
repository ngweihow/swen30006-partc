package mycontroller.tactics;

import mycontroller.datastructure.Node;
import world.WorldSpatial;


import java.util.ArrayList;
import java.util.Collections;

public class AvoidLava implements ITraversalTactic {

    private ArrayList<Node> radius;
    private Node source;
    private static final int RANGE = 2;

    public AvoidLava(Node currentNode) {
        this.source = currentNode;
    }

    /**
     * Scan the current node and returns the direction of which should be travelled
     * @param node The current node that the scan would start from
     * @return The enum variable of a Direction to travel
     */
    public WorldSpatial.Direction scanForLava(Node node) {

        // Create an ArrayList to check all the directions
        ArrayList<Integer> directionWeights = new ArrayList<>();
        directionWeights.add(seekDirection(WorldSpatial.Direction.NORTH, RANGE, 0,node));
        directionWeights.add(seekDirection(WorldSpatial.Direction.EAST, RANGE, 0,node));
        directionWeights.add(seekDirection(WorldSpatial.Direction.SOUTH, RANGE, 0,node));
        directionWeights.add(seekDirection(WorldSpatial.Direction.WEST, RANGE, 0,node));

        // Check for which direction has the 'lightest' weight and decide to go to it
        int cheapestDirection = directionWeights.indexOf(Collections.min(directionWeights));
        // Select the cheapest and return that direction
        switch(cheapestDirection) {
            case 0:
                return WorldSpatial.Direction.NORTH;

            case 1:
                return WorldSpatial.Direction.EAST;

            case 2:
                return WorldSpatial.Direction.SOUTH;

            case 3:
                return WorldSpatial.Direction.WEST;

        }

        // Return null otherwise
        return null;
    }

    /**
     * Seek into the respective neighbour node and accumulate the weights in the direction
     * @param direction The direction enum to look in
     * @param range The range of tiles to be checked
     * @param weights The sum of all the weights
     * @param node The current node it is checking
     * @return The total weights it has in the direction
     */
    public int seekDirection(WorldSpatial.Direction direction, int range, int weights, Node node) {

        // Base case of recursion
        if(range == 0) {
            return 0;
        }

        // Check the direction of the scan and recurse
        switch (direction) {

            case NORTH:
                weights += node.getWeight();
                range--;
                seekDirection(WorldSpatial.Direction.NORTH, range, weights, node.getNorthNode());
                break;

            case EAST:
                weights += node.getWeight();
                range--;
                seekDirection(WorldSpatial.Direction.EAST, range, weights, node.getEastNode());
                break;

            case SOUTH:
                weights += node.getWeight();
                range--;
                seekDirection(WorldSpatial.Direction.SOUTH, range, weights, node.getSouthNode());
                break;

            case WEST:
                weights += node.getWeight();
                range--;
                seekDirection(WorldSpatial.Direction.WEST, range, weights, node.getWestNode());
                break;
        }


        return 0;
    }




    @Override
    public void travel() {

    }
}
