package mycontroller;

import controller.AIController;
import mycontroller.datastructure.Atlas;
import mycontroller.datastructure.Graph;
import mycontroller.datastructure.Node;
import mycontroller.strategies.PathFinder;
import mycontroller.tactics.Driver;
import tiles.MapTile;
import utilities.Coordinate;
import world.Car;
import world.World;

/*import tiles.MapTile;
import utilities.Coordinate;
import world.Car;
import controller.AIController;
import world.World;*/


import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MyAIController extends AIController {
    private HashMap<Coordinate, MapTile> map;

    private Graph graph;

    private Node source;
    private Node destination;

    private PathFinder pathFinder;

    private Stack<Node> solution;

    private Driver driver;

    private Atlas atlas;

    public MyAIController(Car car) {
        super(car);

        this.atlas = new Atlas();
        atlas.initAtlas(this);

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
