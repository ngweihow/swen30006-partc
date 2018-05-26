package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.LavaTrap;
import tiles.MapTile;
import utilities.Coordinate;
import world.WorldSpatial;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RetrieveKey implements ITraversalTactic {

    private Node source;
    private static final int RANGE = 9;
    private Map<Node, MapTile> graph;
    private int currentKey;

    // Constructor
    public RetrieveKey(Node currentNode, Map<Node, MapTile> graph, int currentKey) {
        this.source = currentNode;
        this.graph = graph;
        this.currentKey = currentKey;
    }


    /**
     * Seek into the respective neighbour node and check for instances of keys
     * @param direction The direction enum to look in
     * @param range The range of tiles to be checked
     * @param node The current node it is checking
     * @return The indicator if there is a key in that direction
     */
    public Node scanDirection(WorldSpatial.Direction direction, int range, Node node) {

        // Base case of recursion
        if(range == 0) {
            return null;
        }

        // Check if the node is in the graph
        if(graph.containsKey(node)) {
            // Get the corresponding MapTile from the graph
            MapTile tile = graph.get(node);

            // Check to see if it is Lava
            if(tile.isType((MapTile.Type.TRAP)) && (tile instanceof LavaTrap)) {
                // Get the key for it and see if it is the key we want
                LavaTrap lavaTile = (LavaTrap) tile;

                if(lavaTile.getKey() == currentKey) {
                    return node;
                }
            }

        }

        // Check the direction of the scan and recurse
        switch (direction) {

            case NORTH:
                return scanDirection(WorldSpatial.Direction.NORTH, range, node.getNorthNode());

            case EAST:
                return scanDirection(WorldSpatial.Direction.EAST, range, node.getEastNode());

            case SOUTH:
                return scanDirection(WorldSpatial.Direction.SOUTH, range, node.getSouthNode());

            case WEST:
                return scanDirection(WorldSpatial.Direction.WEST, range, node.getWestNode());

        }

        return null;
    }


    /**
     * Travel to the node where the key is
     * @return Node for the strategy to know where to travel to
     */
    @Override
    public Node travel(HashMap<Coordinate, MapTile> currentView ) {

        // Set all the Node references
        Node northernNode = scanDirection(WorldSpatial.Direction.NORTH, RANGE, this.source);
        Node easternNode = scanDirection(WorldSpatial.Direction.EAST, RANGE, this.source);
        Node southernNode = scanDirection(WorldSpatial.Direction.SOUTH, RANGE, this.source);
        Node westernNode = scanDirection(WorldSpatial.Direction.WEST, RANGE, this.source);

        // Check if any of the scans return null if not return the node to go to
            if(northernNode != null) {
                return northernNode;
            }

            else if (easternNode != null) {
                return easternNode;
            }

            else if (southernNode != null) {
                return southernNode;
            }

            else if (westernNode != null) {
                return westernNode;
            }

            return null;
    }
}
