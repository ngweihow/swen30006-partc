package mycontroller;

import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import mycontroller.strategies.PathFinder;
import mycontroller.tactics.Driver;

import tiles.MapTile;
import utilities.Coordinate;
import world.Car;
import controller.AIController;
import world.World;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MyAIController extends AIController{
    private HashMap<Coordinate, MapTile> map;

    private Graph graph;

    private Node source;
    private Node destination;

    private PathFinder pathFinder;

    private Stack<Node> solution;

    private Driver driver;

    public MyAIController(Car car) {
        super(car);

        // Get the tiled map
        this.map = World.getMap();

        // Get the graph
        this.graph = new Graph(map);

        // Get start and end nodes
        this.source = new Node(new Coordinate(getPosition()));
        this.destination = graph.getDestination();

        // Get path to exit
        this.pathFinder = new PathFinder(graph.getGraph(), source, destination);
        this.solution = pathFinder.findShortestPath();

        System.out.println(solution.size());

        // printPath(solution);

        // Get Driver
        this.driver = new Driver(this, solution);
    }

    public void printPath(Stack<Node> solution) {
        Stack<Node> newStack = new Stack<>();
        newStack.addAll(solution);

        while (!newStack.isEmpty()) {
            Node current = newStack.pop();
            System.out.format("%d,%d\n", current.getX(), current.getY());
        }
    }

    @Override
    public void update(float delta) {
        driver.driveCar(delta);
    }

}
