package mycontroller.data_structure;

import tiles.MapTile;
import utilities.Coordinate;
import java.util.HashMap;

public class Graph {
    private HashMap<Coordinate, MapTile> map;
    
    public Graph(HashMap<Coordinate, MapTile> map){
        this.map = map;
    }
}
