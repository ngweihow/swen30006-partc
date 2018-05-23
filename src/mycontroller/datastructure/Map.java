package mycontroller.datastructure;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class Map {

    // World Map which is only recorded for traps and used for reference
    private HashMap<Node, MapTile> recordedMap;

    // Getting 
    public HashMap<Node, MapTile> getRecordedMap() {
        return recordedMap;
    }
}
