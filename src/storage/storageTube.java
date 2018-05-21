package storage;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public class storageTube implements storage {
    private HashMap<Coordinate, MapTile> data;


    @Override
    public MapTile getCord(Coordinate coordinate) {
        if(data.containsKey(new Coordinate(coordinate.x, coordinate.y))){
            return data.get(new Coordinate(coordinate.x, coordinate.y));
        }

        return null;
    }

    @Override
    public boolean saveCord(Coordinate coordinate, MapTile tile) {
        if(data.containsKey(new Coordinate(coordinate.x, coordinate.y))){
            data.put(new Coordinate(coordinate.x, coordinate.y),tile);
            return true;
        }
        return false;
    }
}
