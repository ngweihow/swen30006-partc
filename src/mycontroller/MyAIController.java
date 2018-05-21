package mycontroller;

import controller.CarController;
import tiles.MapTile;
import utilities.Coordinate;
import world.Car;
import controller.AIController;
import world.WorldSpatial;
import storage.*;

import java.util.HashMap;

public class MyAIController extends AIController{
    private Integer keys=0;
    private float health=100;
    private Car currentCar;
    private storage storage_tube;


    public MyAIController(Car car) {
        super(car);
        setCurrentCar(car);
        this.storage_tube=new storageTube();

    }

    @Override
    public void update(float delta) {

        // Gets what the car can see
        HashMap<Coordinate, MapTile> currentView = getView();












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
