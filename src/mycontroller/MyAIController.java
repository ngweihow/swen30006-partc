package mycontroller;

import tiles.MapTile;
import utilities.Coordinate;
import world.Car;
import controller.AIController;


import java.util.HashMap;

public class MyAIController extends AIController{
    private Integer keys=0;
    private float health=100;
    private Car currentCar;



    public MyAIController(Car car) {
        super(car);
        setCurrentCar(car);


    }

    @Override
    public void update(float delta) {

        // Gets what the car can see
        HashMap<Coordinate, MapTile> currentView = getView();
        //Gets the map layout with no traps what so ever.
        HashMap<Coordinate, MapTile> globalView = getMap();



















    }

    public Integer getKeys() {
        return keys;
    }

    public void setKeys(Integer keys) {
        this.keys = keys;
    }


    public Car getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(Car currentCar) {
        this.currentCar = currentCar;
    }

}
