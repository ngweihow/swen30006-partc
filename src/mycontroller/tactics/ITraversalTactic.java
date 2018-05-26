package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public interface ITraversalTactic {

    public Node travel(HashMap<Coordinate, MapTile> currentView );

}
