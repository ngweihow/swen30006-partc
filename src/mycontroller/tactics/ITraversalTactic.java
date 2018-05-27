/*
 * Group Number: 111
 * Armaan Dhaliwal-McLeod (837674), Wei How Ng (828472), Haohai Liu (830876)
 */
package mycontroller.tactics;

import mycontroller.datastructure.Node;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.HashMap;

public interface ITraversalTactic {

    Node travel(HashMap<Coordinate, MapTile> currentView );

}
