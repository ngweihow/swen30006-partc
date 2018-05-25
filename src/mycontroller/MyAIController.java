package mycontroller;

import controller.AIController;
import controller.CarController;
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

public class MyAIController extends CarController {
    private Driver driver;

    private Atlas atlas;

    public MyAIController(Car car) {
        super(car);

        this.atlas = new Atlas(this);
        driver = atlas.getDriver();

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
