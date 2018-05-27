/*
 * Group Number: 111
 * Armaan Dhaliwal-McLeod (837674), Wei How Ng (828472), Haohai Liu (830876)
 */
package mycontroller.strategies;

import mycontroller.datastructure.Node;
import mycontroller.datastructure.Graph;
import tiles.MapTile;

import java.util.*;

public class PathFinder {
    // Constructor variables
    private Map<Node, MapTile> graph;

    public PathFinder(Map<Node, MapTile> graph) {
        this.graph = graph;
    }

    /**
     * Finds shortest path in graph.
     * @return stack containing shortest path
     */
    public Stack<Node> findShortestPath(Node source, Node destination) {
        Node current;
        Stack<Node> shortest = new Stack<>();
        Set<Node> unvisited = new HashSet<>();
        Map<Node, Double> dist = new HashMap<>();
        Map<Node, Node> prev = new HashMap<>();

        // Initialise data structures for dijkstra's
        for (Map.Entry<Node, MapTile> entry: graph.entrySet()) {
            dist.put(entry.getKey(), Double.POSITIVE_INFINITY);
            prev.put(entry.getKey(), null);
            unvisited.add(entry.getKey());
        }

        // Distance from source to source
        dist.put(source, 0.0);

        // Visit all unvisited nodes
        while (!unvisited.isEmpty()) {
            current = findClosestNode(dist, unvisited);
            unvisited.remove(current);

            // If current tile is destination, we found a path
            if (current.equals(destination)) {
                break;
            }

            // Go through each neighbour
            for (Node neighbour : current.getNeighbours(unvisited)) {
                // Get distance between neighbour and current node
                double alt = dist.get(current) + neighbour.getWeight();

                // If distance is smaller, update
                if (Double.compare(alt, dist.get(neighbour)) < 0) {
                    dist.put(neighbour, alt);
                    prev.put(neighbour, current);
                }
            }
        }

        current = destination;

        // Construct shortest path with stack
        while (prev.get(current) != null) {
            shortest.push(current);
            current = prev.get(current);
        }
        shortest.push(current);

        return shortest;
    }

    /**
     * Finds closest node to current node
     * @param dist distances of nodes
     * @param unvisited unvisited nodes left in the graph
     * @return closest node available
     */
    private Node findClosestNode(Map<Node, Double> dist, Set<Node> unvisited) {
        Double currentMinimum = Double.MAX_VALUE;
        ArrayList<Node> unvisitedNodes = new ArrayList<>(unvisited);
        Node minimum = unvisitedNodes.get(0);

        for (int i = 1; i < unvisitedNodes.size(); i++) {
            Node currentNode = unvisitedNodes.get(i);
            Double currentDist = dist.get(currentNode);

            // If current distance is less than minimum, update
            if (Double.compare(currentDist, currentMinimum) < 0) {
                minimum = currentNode;
                currentMinimum = currentDist;
            }
        }

        return minimum;
    }
}
