package mycontroller.strategies;

import mycontroller.datastructure.Node;
import mycontroller.datastructure.Graph;
import tiles.MapTile;

import java.util.*;

public class PathFinder {
    // Constructor variables
    private Map<Node, MapTile> graph;
    private Node source;
    private Node destination;

    public PathFinder(Map<Node, MapTile> graph, Node source, Node destination) {
        this.graph = graph;
        this.source = source;
        this.destination = destination;
    }

    /**
     * Finds shortest path in graph.
     * @return stack containing shortest path
     */
    public Stack<Node> findShortestPath() {
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
        Node minimum = null;

        // Go through all the unvisited nodes
        for (Node node: unvisited) {
            if (dist.containsKey(node)) {
                Double currentDist = dist.get(node);

                // If current distance is less than minimum, update
                if (Double.compare(currentDist, currentMinimum) < 0) {
                    minimum = node;
                    currentMinimum = currentDist;
                }
            }
        }

        return minimum;
    }
}
