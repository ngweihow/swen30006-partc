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
        this.destination = new Node(new Coordinate(getPosition()));

        // Get path to exit
        this.pathFinder = new PathFinder(graph.getGraph(), source, destination);
        this.solution = pathFinder.findShortestPath();

        // Get Driver
        // this.driver = new Driver(this, solution);
    }

    @Override
    public void update(float delta) {
        //driver.driveCar(delta);
    }

}
