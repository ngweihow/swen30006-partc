package mycontroller.data_structure;

import tiles.MapTile;
import utilities.Coordinate;
import world.Car;
import controller.AIController;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.HashMap;
import java.util.Iterator;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<Node>();

    public Graph( HashMap<Coordinate, MapTile> map){

        for (Coordinate key : map.keySet() ) {
            Node newNode=new Node(key);
            nodes.add(newNode);
        }

    }
}
