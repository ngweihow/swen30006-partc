package mycontroller.data_structure;

import utilities.*;
import java.util.ArrayList;

public class Node {

    private Coordinate coord;

    private ArrayList<Node> neighbours;
    private int weight;

    public static final int DEFAULT_WEIGHT=10;
    public static final int WELL_EXPLORED = 4;

    public Node(Coordinate coord,int weight) {
        this.coord = coord;
        this.neighbours = new ArrayList<>();
        this.weight=weight;
    }

    public boolean findNearest(ArrayList<Node> nodes) {
        // Return null if there the node is already well explored
        if (nodes.size() == WELL_EXPLORED) {
            return false;
        }

        // Check all neighbours
        for(Node neighbour: nodes) {
            Coordinate neighbourCord = neighbour.getCoord();

            // Check horizontal neighbours
            if(Math.abs(neighbourCord.x-getCoord().x)==1) {
                if(Math.abs(neighbourCord.y - getCoord().y)==0){
                    if(!neighbours.contains(neighbour)){
                        neighbours.add(neighbour);
                    }
                }

            }

            // Check Vertical neighbours
            if(Math.abs(neighbourCord.x-getCoord().x)==0) {
                if(Math.abs(neighbourCord.y - getCoord().y)==1){
                    if(!neighbours.contains(neighbour)){
                        neighbours.add(neighbour);
                    }
                }

            }


        }
        return true;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }
}
