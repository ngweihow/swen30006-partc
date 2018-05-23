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
        Node up = new Node(new Coordinate(x, y+1));
        if (unvisited.contains(up)) {
            neighbours.add(up);
        }

        // Down
        Node down = new Node(new Coordinate(x, y-1));
        if (unvisited.contains(down)) {
            neighbours.add(down);
        }

        // Left
        Node left = new Node(new Coordinate(x-1, y));
        if (unvisited.contains(left)) {
            neighbours.add(left);
        }

        // Right
        Node right = new Node(new Coordinate(x+1, y));
        if (unvisited.contains(right)) {
            neighbours.add(right);
        }

        return neighbours;

    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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
