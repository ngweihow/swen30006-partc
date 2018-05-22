package mycontroller.data_structure;

import utilities.*;
import java.util.ArrayList;

public class Node {

    private Coordinate coord;

    private ArrayList<Node> neighbours;
    private int weight;

    private static final int DEFAULT_WEIGHT=10;
    private static final int WELL_EXPLORED = 4;

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
            Coordinate neighbourCord = neighbour.getCord();

            if(Math.abs(neighbourCord.x-getCord().x)==1) {
                if(Math.abs(neighbourCord.y - getCord().y)==0){
                    if(!neighbours.contains(neighbour)){
                        neighbours.add(neighbour);

                    }
                }

            }
            if(Math.abs(neighbourCord.x-getCord().x)==0) {
                if(Math.abs(neighbourCord.y - getCord().y)==1){
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

    public static int getDefaultWeight() {
        return DEFAULT_WEIGHT;
    }

    public static int getWellExplored() {
        return WELL_EXPLORED;
    }

    public Coordinate getCord() {
        return coord;
    }

    public void setCord(Coordinate cord) {
        this.coord = cord;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }
}
