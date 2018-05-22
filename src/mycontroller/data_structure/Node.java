package mycontroller.data_structure;

import utilities.*;

public class Node {

    private Coordinate coord;
    private int x;
    private int y;

    public Node(Coordinate coord) {
        this.coord = coord;
        this.x = coord.x;
        this.y = coord.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }


    public Coordinate getCord() {
        return coord;
    }

    public void setCord(Coordinate cord) {
        this.coord = cord;
    }

}
