package mycontroller.strategies;

import mycontroller.datastructure.Node;
import mycontroller.datastructure.Graph;
import tiles.MapTile;

import java.util.*;

public class PathFinder {
    // Constructor variables
    private Graph graph;
    private Node source;
    private Node destination;

    // Keep a set of unvisited nodes
    private Set<Node> unvisited;

    // Record distances in hashmap
    private Map<Node, Double> dist;

    // Record previous nodes
    private Map<Node, Node> prev;

    // Shortest path stored here
    private Stack<Node> shortest;

    public PathFinder(Graph graph, Node source, Node destination) {
        this.graph = graph;
        this.source = source;
        this.destination = destination;

        this.unvisited = new HashSet<>();
        this.dist = new HashMap<>();
        this.prev = new HashMap<>();

        this.shortest = findShortestPath();
    }

    // Get shortest path
    public Stack<Node> findShortestPath() {
        Node current;
        Stack<Node> shortest = new Stack<>();

        // Initialise data structures for djkistras
        for (Map.Entry<Node, MapTile> entry: graph.getGraph().entrySet()) {
            dist.put(entry.getKey(), new Double(Double.POSITIVE_INFINITY));
            prev.put(entry.getKey(), null);
            unvisited.add(entry.getKey());
        }

        // Distance from source to source
        dist.put(source, 0.0);

        // Visit all unvisited nodes
        while (!unvisited.isEmpty()) {
            current = findClosestNode(dist, unvisited);
            unvisited.remove(current);

            // Go through each neighbour
            for (Node neighbour : current.getNeighbours(unvisited)) {
                if (neighbour.getWeight() != Double.POSITIVE_INFINITY) {
                    // Get distance between neighbour and current node
                    double alt = dist.get(current) + neighbour.getWeight();

                    // If distance is smaller, update
                    if (Double.compare(alt, dist.get(neighbour)) < 0) {
                        dist.put(neighbour, alt);
                        prev.put(neighbour, current);
                    }
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

    // Get closes node still in unvisited set
    public Node findClosestNode(Map<Node, Double> dist, Set<Node> unvisited) {
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
