package mycontroller.tactics;

import tiles.MapTile;
import tiles.TrapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class avoidLava implements TraversalTactic {

    @Override
    public boolean tacticalBehaviour(HashMap<Coordinate, MapTile> currentView,Coordinate coordinate) {

        MapTile tile=currentView.get(new Coordinate(coordinate.x, coordinate.y));

        if(tile.isType(MapTile.Type.TRAP)){
            TrapTile trapTile = (TrapTile) tile;
            return !trapTile.getTrap().equals("lava");
        }
        return true;
    }
}
