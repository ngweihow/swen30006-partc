package mycontroller.data_structure;

import utilities.Coordinate;
import java.util.ArrayList;

public class Node {

    private Coordinate coord;

    private ArrayList<Node> neighbours;

    private static final int DEFAULT_WEIGHT=10;
    private static final int WELL_EXPLORED = 4;

    public Node(Coordinate coord) {
        this.coord = coord;
        this.neighbours = new ArrayList<>();
    }

    public ArrayList<Node> findNearest(ArrayList<Node> nodes) {


        // Return null if there the node is already well explored
        if (nodes.size() == WELL_EXPLORED) {
            return null;
        }

        // Check all neighbours
        for(Node neighbour: nodes) {
            Coordinate neighbourCord = neighbour.getCord();

            if(neighbourCord.x-getCord().x==1) {
                if((neighbourCord.y - getCord().y)==0){
                    if(neighbours.contains(nodes)){

                    }

                }

            }
            if(neighbourCord.x-getCord().x==0) {
                if((neighbourCord.y - getCord().y)==1){

                }

            }


        }
        return null;
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
