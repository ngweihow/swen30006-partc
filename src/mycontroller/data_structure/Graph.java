package mycontroller.data_structure;

import tiles.MapTile;
import tiles.TrapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class Graph {

    private final int WALL=10000;
    private final int FINISH=1;
    private final int START=10;
    private final int ROAD=10;
    private final int TRAP_BAD=1000;
    private final int TRAP_GOOD=5;
    private final int TILE_NOT_FOUND=-1;

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
            Coordinate key = entry.getKey();
            Node newNode = new Node(key, weight(map.get(new Coordinate(key.x, key.y))));
            graph.put(newNode, entry.getValue());
        }

        return graph;
    }

    public int weight(MapTile tile) {

        if (tile.isType(MapTile.Type.TRAP)) {
            TrapTile trapTile = (TrapTile) tile;
            if (trapTile.getTrap().equals("health")) {
                return TRAP_GOOD;

            }
            if (trapTile.getTrap().equals("lava")) {
                return TRAP_BAD;

            }

        }
        if (tile.isType(MapTile.Type.WALL)) {
            return WALL;
        }

        if (tile.isType(MapTile.Type.FINISH)) {
            return FINISH;
        }
        if (tile.isType(MapTile.Type.START)) {
            return START;

        }
        if (tile.isType(MapTile.Type.ROAD)) {
            return ROAD;
        }

        return TILE_NOT_FOUND;
    }
}
