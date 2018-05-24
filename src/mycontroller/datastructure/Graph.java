package mycontroller.datastructure;

import tiles.MapTile;
import tiles.TrapTile;
import utilities.Coordinate;
import world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    private static final int FINISH = 0;
    private static final int DEFAULT = 1;
    private static final int LAVA_TRAP = World.MAP_HEIGHT * World.MAP_WIDTH;
    private static final int HEALTH_TRAP = 5;

    private static final String LAVA = "lava";
    private static final String HEALTH = "health";

    // Map of world
    private HashMap<Coordinate, MapTile> map;

    // Graph which contains contents of map
    private Map<Node, MapTile> graph;

    // Coordinate to Node HashMap
    private ArrayList<Node> nodeList;

    // Get source and destination of map
    private Node destination;

    // Singleton constructor (Package private)
    public Graph(HashMap<Coordinate, MapTile> map) {
        this.map = map;
        this.nodeList = new ArrayList<>();

        this.graph = createGraph();

        this.destination = getDestination(graph);

        setAllNodeNeighbours(nodeList);
    }

    /**
     * Creates the Graph Data Structure from data returned from getMap
     * @return Map
     */
    private Map<Node, MapTile> createGraph() {
        Map<Node, MapTile> graph = new HashMap<>();

        // Go over the coordinate and tiles of map
        for (HashMap.Entry<Coordinate, MapTile> entry : map.entrySet()) {

            // Get the key for the respective node and hash it into the graph
            Node newNode = new Node(entry.getKey());
            addWeight(entry.getValue(), newNode);
            graph.put(newNode, entry.getValue());

            // Hash node to the coordMap using coord as key
            nodeList.add(newNode);
        }

        return graph;
    }


    /**
     * Setting all the neighbour nodes to a node
     */
    public void setAllNodeNeighbours(ArrayList<Node> nodeList) {

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

    public Node getDestination(Map<Node, MapTile> graph) {
        for (Map.Entry<Node, MapTile> entry: graph.entrySet()) {
            if (entry.getValue().isType(MapTile.Type.FINISH)) {
                return entry.getKey();
            }
        }

        return null;
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

    // Get destination
    public Node getDestination() {
        return destination;
    }

    // Get graph
    public Map<Node, MapTile> getGraph() {
        return graph;
    }
}
