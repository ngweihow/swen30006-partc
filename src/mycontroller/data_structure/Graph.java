package mycontroller.data_structure;

import tiles.MapTile;
import tiles.TrapTile;
import utilities.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private final int WALL=10000;
    private final int FINISH=1;
    private final int START=10;
    private final int ROAD=10;
    private final int TRAP_BAD=1000;
    private final int TRAP_GOOD=5;


    private ArrayList<Node> nodes = new ArrayList<Node>();


    private HashMap<Coordinate, MapTile> map;

    public Graph(HashMap<Coordinate, MapTile> map) {

        for (Coordinate key : map.keySet()) {
            Node newNode = new Node(key,weight(map.get(new Coordinate(key.x,key.y))));
            nodes.add(newNode);
        }
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
    }
}
