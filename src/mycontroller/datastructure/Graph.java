package mycontroller.datastructure;

import tiles.MapTile;
import tiles.TrapTile;
import utilities.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    private static final int FINISH=1;
    private static final int START=10;
    private static final int LAVA_TRAP=1000;
    private static final int HEALTH_TRAP=5;
    private static final int TILE_NOT_FOUND=-1;

    private static final String LAVA = "lava";
    private static final String HEALTH = "health";

    // Map of world
    private HashMap<Coordinate, MapTile> map;

    // Graph which contains contents of map
    private Map<Node, MapTile> graph;

    // Coordinate to Node HashMap
    private HashMap<Coordinate, Node> coordMap;


    // Singleton constructor (Package private)
    Graph(HashMap<Coordinate, MapTile> map) {
        this.map = map;
        this.graph = createGraph();
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
            newNode.setWeight(weight(entry.getValue()));
            graph.put(newNode, entry.getValue());

            // Hash node to the coordMap using coord as key
            coordMap.put(entry.getKey(), newNode);
        }

        return graph;
    }


    public void setAllNodeNeighbours() {

        // Go over each coordinate in the coordinate hash and assign
        for(HashMap.Entry<Coordinate, Node> entry: coordMap.entrySet()) {



        }
    }


    /**
     * Setting the weight of the Node object depending on the tile type
     * @param tile
     * @return
     */
    public int weight(MapTile tile) {

        // Only assign tiles new weights when
        if (tile.isType(MapTile.Type.TRAP)) {
            TrapTile trapTile = (TrapTile) tile;

            // For each trap tile check the type for it
            if (trapTile.getTrap().equals(HEALTH)) {
                return HEALTH_TRAP;
            }

            else if (trapTile.getTrap().equals(LAVA)) {
                return LAVA_TRAP;
            }

        }

        // If it is not a trap
        else if (tile.isType(MapTile.Type.FINISH)) {
            return FINISH;
        }

        else if (tile.isType(MapTile.Type.START)) {
            return START;
        }

        return TILE_NOT_FOUND;
    }

    // Get graph
    public Map<Node, MapTile> getGraph() {
        return graph;
    }
}
