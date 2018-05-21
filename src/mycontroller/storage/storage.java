package mycontroller.storage;

import tiles.MapTile;
import utilities.Coordinate;

public interface storage {

    public MapTile getCord(Coordinate coordinate);

    public boolean saveCord(Coordinate coordinate,MapTile tile);

}
