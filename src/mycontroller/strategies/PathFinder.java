package mycontroller.strategies;

import mycontroller.data_structure.Node;
import mycontroller.data_structure.Graph;
import tiles.MapTile;
import utilities.Coordinate;

import java.util.*;

public class PathFinder {
    private Graph graph;
    private Node source;
    private Node destination;

    // Keep a set of unvisited nodes
    private Set<Node> unvisited;

    // Recprd distances in hashmap
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
        this.shortest = new Stack<>();

        findShortestPath();

    }

    // Get shortest path
    public void findShortestPath() {
        Node current;
        Node previous;

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
            for (Node neighbour : getNeighbours(unvisited, current)) {

                // Get distance between neighbour and current node
                double alt = dist.get(current) + Math.abs(dist.get(current) - dist.get(neighbour));

                // If distance is smaller, update
                if (Double.compare(alt, dist.get(neighbour)) < 0) {
                    dist.put(neighbour, alt);
                    prev.put(neighbour, current);
                }
            }

            current = destination;

            // Construct shortest path with stack
            while (prev.get(current) != null) {
                shortest.push(current);
                current = prev.get(current);
            }
            shortest.push(current);
        }
    }

    // Get neighbouring nodes
    public ArrayList<Node> getNeighbours(Set<Node> unvisited, Node current) {
        ArrayList<Node> neighbours = new ArrayList<>();

        int x = current.getX();
        int y = current.getY();

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
