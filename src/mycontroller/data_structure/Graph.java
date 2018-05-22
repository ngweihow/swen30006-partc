package mycontroller.data_structure;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<Node>();

    private HashMap<Coordinate, MapTile> map;

    public Graph( HashMap<Coordinate, MapTile> map){

        for (Coordinate key : map.keySet() ) {
            Node newNode=new Node(key);
            nodes.add(newNode);
        }
    }
}
