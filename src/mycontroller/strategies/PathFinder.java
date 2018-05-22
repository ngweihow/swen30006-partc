package mycontroller.strategies;

import mycontroller.data_structure.Node;
import mycontroller.data_structure.Graph;
import tiles.MapTile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public PathFinder(Graph graph, Node source, Node destination) {
        this.graph = graph;
        this.source = source;
        this.destination = destination;

        this.unvisited = new HashSet<>();
        this.dist = new HashMap<>();
        this.prev = new HashMap<>();

        initialise();

    }

    // Initialise data structures for djkistras
    public void initialise() {
        for (Map.Entry<Node, MapTile> entry: graph.getGraph().entrySet()) {
            dist.put(entry.getKey(), new Double(Double.POSITIVE_INFINITY));
            prev.put(entry.getKey(), null);
            unvisited.add(entry.getKey());
        }

        dist.put(source, 0.0);
    }


}
