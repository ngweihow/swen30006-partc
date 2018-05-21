package storage;

import tiles.MapTile;
import utilities.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;

public interface storage {

    public MapTile getCord(Coordinate coordinate);

    public boolean saveCord(Coordinate coordinate,MapTile tile);

}
