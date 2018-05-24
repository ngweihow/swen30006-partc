package mycontroller.datastructure;

import utilities.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class Node {

    // Coordinates, Neighbour Nodes and Weights
    private Coordinate coord;
    private int x;
    private int y;
    private int weight;

    // Neighbour Nodes
    private Node westNode;
    private Node eastNode;
    private Node northNode;
    private Node southNode;

    private static final int DEFAULT_WEIGHT = 10;

    public Node(Coordinate coord) {
        this.coord = coord;
        this.x = coord.x;
        this.y = coord.y;
        this.weight = DEFAULT_WEIGHT;
    }

    /**
     * Get neighbouring nodes of current node
     * @param unvisited unvisited nodes left in graph
     * @return list containing neighbours of node
     */
    public ArrayList<Node> getNeighbours(Set<Node> unvisited) {
        ArrayList<Node> neighbours = new ArrayList<>();

        // Up
        if (unvisited.contains(getNorthNode())) {
            neighbours.add(getNorthNode());
        }

        // Down
        if (unvisited.contains(getSouthNode())) {
            neighbours.add(getSouthNode());
        }

        // Left
        if (unvisited.contains(getWestNode())) {
            neighbours.add(getWestNode());
        }

        // Right
        if (unvisited.contains(getEastNode())) {
            neighbours.add(getEastNode());
        }

        return neighbours;

    }

    public boolean checkPosition(Node other) {
        return x == other.getX() && y == other.getY();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public Node getWestNode() {
        return westNode;
    }

    public void setWestNode(Node westNode) {
        this.westNode = westNode;
    }

    public Node getEastNode() {
        return eastNode;
    }

    public void setEastNode(Node eastNode) {
        this.eastNode = eastNode;
    }

    public Node getNorthNode() {
        return northNode;
    }

    public void setNorthNode(Node northNode) {
        this.northNode = northNode;
    }

    public Node getSouthNode() {
        return southNode;
    }

    public void setSouthNode(Node southNode) {
        this.southNode = southNode;
    }
}
