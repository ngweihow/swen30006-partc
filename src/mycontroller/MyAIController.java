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

        // Initialise Atlas
        this.atlas = new Atlas(this);
    }

    /**
     * Overriden update method to update the rendering and driving
     * @param delta Value to work with the physics of the car
     */
    @Override
    public void update(float delta) {
        atlas.getDriver().driveCar(delta);
    }

}
