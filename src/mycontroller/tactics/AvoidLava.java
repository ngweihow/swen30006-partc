package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.MapTile;
import tiles.TrapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class AvoidLava implements ITraversalTactic {

    public AvoidLava() {

    }


    public boolean tacticalBehaviour(HashMap<Node, MapTile> currentView,Coordinate coordinate) {

        MapTile tile=currentView.get(new Coordinate(coordinate.x, coordinate.y));

        if(tile.isType(MapTile.Type.TRAP)){
            TrapTile trapTile = (TrapTile) tile;
            return !trapTile.getTrap().equals("lava");
        }
        return true;
    }

    @Override
    public void travel() {

    }
}
