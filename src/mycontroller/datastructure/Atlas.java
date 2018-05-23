package mycontroller.datastructure;

import tiles.MapTile;
import utilities.Coordinate;
import world.World;

import java.util.HashMap;

public class Atlas {

    public Atlas() {

    }

    public void initAtlas() {

        // Get Initial Map from World Package
        HashMap<Coordinate, MapTile> originalMap;
        originalMap = World.getMap();

        // Initialise Graph
        Graph graph = new Graph(originalMap);


    }
}
