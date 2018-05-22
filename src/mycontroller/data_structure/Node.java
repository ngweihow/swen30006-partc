package mycontroller.data_structure;

import utilities.Coordinate;
import tiles.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;




public class Node {

    private Coordinate cord;
    private ArrayList<Node> neighbours;
    static final int DEFAULT_WEIGHT=10;

    public Node(Coordinate cord) {
        this.cord = cord;




    }

    public ArrayList<Node> findNearest(ArrayList<Node> nodes) {


        // Return null if there the node is already well explored
        if (nodes.size() == 4) {
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
        return cord;
    }

    public void setCord(Coordinate cord) {
        this.cord = cord;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }
}
