package mycontroller.datastructure;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class Map {

    // World Map which is only recorded for traps and used for reference
    private HashMap<Node, MapTile> recordedMap;


    public Map(HashMap<Node, MapTile> recordedMap) {
        this.recordedMap = recordedMap;
    }

    // Getting the recorded HashMap from the World Class
    public HashMap<Node, MapTile> getRecordedMap() {
        return recordedMap;
    }
}
