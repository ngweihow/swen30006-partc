/*
 * Group Number: 111
 * Armaan Dhaliwal-McLeod (837674), Wei How Ng (828472), Haohai Liu (830876)
 */
package mycontroller;

import controller.CarController;
import mycontroller.datastructure.Atlas;
import world.Car;

public class MyAIController extends CarController {
    private Atlas atlas;

    public MyAIController(Car car) {
        super(car);

        this.atlas = new Atlas(this);
    }

    @Override
    public void update(float delta) {
        atlas.getDriver().driveCar(delta);
    }

}
