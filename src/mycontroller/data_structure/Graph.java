package mycontroller.data_structure;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class Graph {
    // Map of world
    private HashMap<Coordinate, MapTile> map;

    // Graph which contains contents of map
    private HashMap<Node, MapTile> graph;

    public Graph(HashMap<Coordinate, MapTile> map) {
        this.map = map;
        this.graph = createGraph();
    }

    // Creates a graph of map tiles
    public HashMap<Node, MapTile> createGraph() {
        HashMap<Node, MapTile> graph = new HashMap<>();

        // Go over the coordinate and tiles of map
        for (HashMap.Entry<Coordinate, MapTile> entry: map.entrySet()) {
            Node newNode = new Node(entry.getKey());
            graph.put(newNode, entry.getValue());
        }

        return graph;
    }


}
