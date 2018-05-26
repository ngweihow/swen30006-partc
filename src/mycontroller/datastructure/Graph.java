package mycontroller.datastructure;

import tiles.MapTile;
import tiles.TrapTile;
import utilities.Coordinate;
import world.World;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    // Instantiation of the static Singleton Class Graph
    private static final Graph GRAPH_INSTANCE = new Graph();

    private static final int FINISH = 0;
    private static final int DEFAULT = 1;
    private static final int LAVA_TRAP;
    private static final int HEALTH_TRAP = 5;

    private static final String LAVA = "lava";
    private static final String HEALTH = "health";

    // Graph which contains contents of map
    private static Map<Node, MapTile> graph;

    // Coordinate to Node HashMap
    private static ArrayList<Node> nodeList;

    static {
        LAVA_TRAP = World.MAP_HEIGHT * World.MAP_WIDTH;
    }

    // Singleton constructor (Package private)
    Graph() {

        // Variable for the original map from getMap
        HashMap<Coordinate, MapTile> originalMap;

        // Get Initial Map from World Package
        originalMap = World.getMap();

        // Initialse node list
        nodeList = new ArrayList<>();

        graph = new HashMap<>();

        // Go over the coordinate and tiles of map
        for (HashMap.Entry<Coordinate, MapTile> entry : originalMap.entrySet()) {

            // Get the key for the respective node and hash it into the graph
            Node newNode = new Node(entry.getKey());
            addWeight(entry.getValue(), newNode);
            graph.put(newNode, entry.getValue());

            // Add Nodes to List of Nodes
            nodeList.add(newNode);
        }

    }

    /**
     * Returns the Graph Instant Structure from data
     * @return The Singleton Graph Instantiation
     */
    public static Graph getGraph() {

        // Return GRAPH_INSTANCE
        return GRAPH_INSTANCE;
    }

    /**
     * Return hashmap graph of nodes
     * @return The hashmap graph =
     */
    public static Map<Node, MapTile> getGraphNodes() {
        return graph;
    }


    /**
     * Setting all the neighbour nodes to a node
     */
    public void setAllNodeNeighbours() {

        // Go over each coordinate in the coordinate hash and assign
        for(Node node: nodeList) {
            // Check other nodes
            for(Node otherNode: nodeList) {
                // Setting the NorthNode for this node
                if((node.getX() == otherNode.getX()) && ((node.getY()+ 1) == otherNode.getY())) {
                    node.setNorthNode(otherNode);
                }

                // Setting the EastNode for this node
                if((node.getY() == otherNode.getY()) && ((node.getX()+ 1) == otherNode.getX())) {
                    node.setEastNode(otherNode);
                }

                // Setting the SouthNode for this node
                if((node.getX() == otherNode.getX()) && ((node.getY()- 1) == otherNode.getY())) {
                    node.setSouthNode(otherNode);
                }

                // Setting the WestNode for this node
                if((node.getY() == otherNode.getY()) && ((node.getX()- 1) == otherNode.getX())) {
                    node.setWestNode(otherNode);
                }

            }

        }
    }
    

    /**
     * Setting the weight of the Node object depending on the tile type
     * @param tile
     */
    private void addWeight(MapTile tile, Node node) {

        // Only assign tiles new weights when
        if (tile.isType(MapTile.Type.TRAP)) {
            TrapTile trapTile = (TrapTile) tile;

            // For each trap tile check the type for it
            if (trapTile.getTrap().equals(HEALTH)) {
                node.setWeight(HEALTH_TRAP);
            }

            else if (trapTile.getTrap().equals(LAVA)) {
                node.setWeight(LAVA_TRAP);
            }

        }

        // If it is not a trap
        else if (tile.isType(MapTile.Type.FINISH)) {
            node.setWeight(FINISH);
        } else if (tile.isType(MapTile.Type.WALL)){
            node.setWeight((int)Double.POSITIVE_INFINITY);
        }else if (tile.isType(MapTile.Type.START)) {
            node.setWeight(DEFAULT);
        } else {
            node.setWeight(DEFAULT);
        }
    }

}
