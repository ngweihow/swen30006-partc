package mycontroller.tactics;

import controller.CarController;
import mycontroller.datastructure.Node;
import tiles.LavaTrap;
import tiles.MapTile;
import utilities.Coordinate;
import world.WorldSpatial;

import java.util.HashMap;
import java.util.Stack;

public class Driver {
    // Controller and solution
    private CarController controller;
    private Stack<Node> solution;

    // Variables needed for car physics
    private static final int CAR_SPEED = 4;
    private static int wallSensitivity = 4;
    private static final int EAST_THRESHOLD = 3;
    private static final double SPEED_COEFFICIENT = 0.5;

    // Get current and next tile
    private Node currentTile;
    private Node nextTile;

    // Direction and path properties
    private boolean isFollowingPath;

    // Shows the last turn direction the car takes.
    private WorldSpatial.RelativeDirection lastTurnDirection;
    private boolean isTurningLeft;
    private boolean isTurningRight;

    // Keeps track of the previous state
    private WorldSpatial.Direction previousState;

    public Driver(CarController controller, Stack<Node> solution) {
        this.controller = controller;
        this.solution = solution;

        this.nextTile = solution.pop();
        this.currentTile = null;

        this.isFollowingPath = false;
        this.lastTurnDirection = null;
        this.isTurningLeft = false;
        this.isTurningRight = false;
        this.previousState = null;
    }

    /**
     * Drives car to destination
     * @param delta speed of the car
     */
    public void driveCar(float delta) {
        HashMap<Coordinate, MapTile> currentView = controller.getView();

        // First check if state has changed
        checkStateChange();

        // Get the current tile
        currentTile = new Node(new Coordinate(controller.getPosition()));

        // If not following path
        if (!isFollowingPath) {

            // Car is going to slow, accelerate
            if (controller.getSpeed() < CAR_SPEED) {
                controller.applyForwardAcceleration();
            }
            lastTurnDirection = getDirection(controller.getOrientation(), currentTile, nextTile);

            // Turn left is last turn direction is left
            if (lastTurnDirection == WorldSpatial.RelativeDirection.LEFT) {
                applyLeftTurn(controller.getOrientation(), delta);

            // Turn right if last turn direction is right
            } else if (lastTurnDirection == WorldSpatial.RelativeDirection.RIGHT) {
                applyRightTurn(controller.getOrientation(), delta);

            // Otherwise we are already following path
            } else {
                isFollowingPath = true;
            }

        // We are defiantly following the path
        } else {

            // readjust to suite last turn direction
            readjust(lastTurnDirection, delta);

            // If position is the same as next tile
            if (currentTile.checkPosition(nextTile)) {
                if (!solution.isEmpty()) {
                    nextTile = solution.pop();
                }
            }

            // Check if we are turning left or right
            if (isTurningLeft || isTurningRight) {

                // If we are going to fast
                if(controller.getSpeed() > SPEED_COEFFICIENT) {

                    // Reverse car
                    controller.applyReverseAcceleration();

                    // Left turn becomes right turn
                    // Switched because car goes diagonal otherwise
                    if(isTurningLeft) {
                        applyRightTurn(controller.getOrientation(), delta);

                    // Right turn becomes left turn
                    } else if (isTurningRight) {
                        applyLeftTurn(controller.getOrientation(), delta);
                    }

                // We are going too slow
                } else {

                    // accelerate vehicle
                    controller.applyForwardAcceleration();

                    // Turn normally
                    if(isTurningLeft) {
                        applyLeftTurn(controller.getOrientation(), delta);
                    } else if (isTurningRight) {
                        applyRightTurn(controller.getOrientation(), delta);
                    }
                }
            } else {

                //Going straight ahead, check tiles ahead and slow down if there is a wall/trap ahead
                if(controller.getSpeed() < CAR_SPEED && !checkTileAhead(controller.getOrientation(), currentView, controller.getSpeed())){
                    controller.applyForwardAcceleration();
                }

                //Get the relative direction of the next tile. If no turn, keep going straight
                lastTurnDirection = getDirection(controller.getOrientation(), currentTile, nextTile);
                if(lastTurnDirection == WorldSpatial.RelativeDirection.LEFT){
                    applyLeftTurn(controller.getOrientation(),delta);
                    setTurnLeft(true);
                } else if(lastTurnDirection == WorldSpatial.RelativeDirection.RIGHT) {
                    applyRightTurn(controller.getOrientation(),delta);
                    setTurnRight(true);
                } else {
                    setTurnLeft(false);
                    setTurnRight(false);
                }
            }


        }

    }

    private void setTurnRight(boolean newTurn) {
        this.isTurningRight = newTurn;
    }

    private void setTurnLeft(boolean newTurn) {
        this.isTurningLeft = newTurn;
    }

    /**
     * Gets relative direction of car
     * @param orientation current orientation of vehicle
     * @param currentTile current tile being driven on
     * @param nextTile tile to drive to
     * @return a relative direction of the vehicle
     */
    private WorldSpatial.RelativeDirection getDirection(WorldSpatial.Direction orientation,
                                                        Node currentTile,
                                                        Node nextTile) {
        int x = nextTile.getX() - currentTile.getX();
        int y = nextTile.getY() - currentTile.getY();

        switch(orientation) {
            case NORTH:
                if (x == -1) {
                    return WorldSpatial.RelativeDirection.LEFT;
                } else if (x == 1) {
                    return WorldSpatial.RelativeDirection.RIGHT;
                }
                break;
            case SOUTH:
                if (x == -1) {
                    return WorldSpatial.RelativeDirection.RIGHT;
                } else if (x == 1) {
                    return WorldSpatial.RelativeDirection.LEFT;
                }
                break;
            case EAST:
                if (y == 1) {
                    return WorldSpatial.RelativeDirection.LEFT;
                } else if (y == -1) {
                    return WorldSpatial.RelativeDirection.RIGHT;
                }
                break;
            case WEST:
                if (y == 1) {
                    return WorldSpatial.RelativeDirection.RIGHT;
                } else if (y == -1) {
                    return WorldSpatial.RelativeDirection.LEFT;
                }
                break;
            default:
                break;
        }
        return null;
    }

    /**
     * Readjust the car to the orientation we are in.
     * @param lastTurnDirection direction of last turn taken by the car
     * @param delta timing of vehicle adjusting
     */
    private void readjust(WorldSpatial.RelativeDirection lastTurnDirection, float delta) {
        if(lastTurnDirection != null){
            if(!isTurningRight && lastTurnDirection.equals(WorldSpatial.RelativeDirection.RIGHT)){
                adjustRight(controller.getOrientation(),delta);
            }
            else if(!isTurningLeft && lastTurnDirection.equals(WorldSpatial.RelativeDirection.LEFT)){
                adjustLeft(controller.getOrientation(),delta);
            }
        }

    }

    /**
     * Try to orient myself to a degree that I was supposed to be at if I am
     * misaligned.
     */
    private void adjustLeft(WorldSpatial.Direction orientation, float delta) {

        switch(orientation){
            case EAST:
                if(controller.getAngle() > WorldSpatial.EAST_DEGREE_MIN+EAST_THRESHOLD){
                    controller.turnRight(delta);
                }
                break;
            case NORTH:
                if(controller.getAngle() > WorldSpatial.NORTH_DEGREE){
                    controller.turnRight(delta);
                }
                break;
            case SOUTH:
                if(controller.getAngle() > WorldSpatial.SOUTH_DEGREE){
                    controller.turnRight(delta);
                }
                break;
            case WEST:
                if(controller.getAngle() > WorldSpatial.WEST_DEGREE){
                    controller.turnRight(delta);
                }
                break;

            default:
                break;
        }

    }

    private void adjustRight(WorldSpatial.Direction orientation, float delta) {
        switch(orientation){
            case EAST:
                if(controller.getAngle() > WorldSpatial.SOUTH_DEGREE && controller.getAngle() < WorldSpatial.EAST_DEGREE_MAX){
                    controller.turnLeft(delta);
                }
                break;
            case NORTH:
                if(controller.getAngle() < WorldSpatial.NORTH_DEGREE){
                    controller.turnLeft(delta);
                }
                break;
            case SOUTH:
                if(controller.getAngle() < WorldSpatial.SOUTH_DEGREE){
                    controller.turnLeft(delta);
                }
                break;
            case WEST:
                if(controller.getAngle() < WorldSpatial.WEST_DEGREE){
                    controller.turnLeft(delta);
                }
                break;

            default:
                break;
        }

    }

    /**
     * Checks whether the car's state has changed or not, stops turning if it
     *  already has.
     */
    private void checkStateChange() {
        if(previousState == null){
            previousState = controller.getOrientation();
        }
        else{
            if(previousState != controller.getOrientation()){
                if(isTurningLeft){
                    isTurningLeft = false;
                }
                if(isTurningRight){
                    isTurningRight = false;
                }
                previousState = controller.getOrientation();
            }
        }
    }

    /**
     * Turn the car counter clock wise (think of a compass going counter clock-wise)
     */
    private void applyLeftTurn(WorldSpatial.Direction orientation, float delta) {
        switch(orientation){
            case EAST:
                if(!controller.getOrientation().equals(WorldSpatial.Direction.NORTH)){
                    controller.turnLeft(delta);
                }
                break;
            case NORTH:
                if(!controller.getOrientation().equals(WorldSpatial.Direction.WEST)){
                    controller.turnLeft(delta);
                }
                break;
            case SOUTH:
                if(!controller.getOrientation().equals(WorldSpatial.Direction.EAST)){
                    controller.turnLeft(delta);
                }
                break;
            case WEST:
                if(!controller.getOrientation().equals(WorldSpatial.Direction.SOUTH)){
                    controller.turnLeft(delta);
                }
                break;
            default:
                break;

        }

    }

    /**
     * Turn the car clock wise (think of a compass going clock-wise)
     */
    private void applyRightTurn(WorldSpatial.Direction orientation, float delta) {
        switch(orientation){
            case EAST:
                if(!controller.getOrientation().equals(WorldSpatial.Direction.SOUTH)){
                    controller.turnRight(delta);
                }
                break;
            case NORTH:
                if(!controller.getOrientation().equals(WorldSpatial.Direction.EAST)){
                    controller.turnRight(delta);
                }
                break;
            case SOUTH:
                if(!controller.getOrientation().equals(WorldSpatial.Direction.WEST)){
                    controller.turnRight(delta);
                }
                break;
            case WEST:
                if(!controller.getOrientation().equals(WorldSpatial.Direction.NORTH)){
                    controller.turnRight(delta);
                }
                break;
            default:
                break;

        }

    }

    /**
     * Assigns new wall sensitive depending on speed of car
     * @param speed the speed of the car
     */
    private void assignWallSensitivity(float speed) {
        if(speed <= 1) {
            wallSensitivity = 1;
        } else if(speed > 1) {
            wallSensitivity = 2;
        } else if(speed > 2) {
            wallSensitivity = 3;
        } else {
            wallSensitivity = 4;
        }
    }

    /**
     * Check if you have a wall or trap in front of you!
     * @param orientation the orientation we are in based on WorldSpatial
     * @param currentView what the car can currently see
     * @return boolean indicating if wall or lava is ahead
     */
    //WallSensitivity changes based on how fast the car is currently moving
    private boolean checkTileAhead(WorldSpatial.Direction orientation, HashMap<Coordinate, MapTile> currentView, float speed){
        // First assign wall sensitivity
        assignWallSensitivity(speed);

        switch(orientation){
            case EAST:
                return checkEast(currentView);
            case NORTH:
                return checkNorth(currentView);
            case SOUTH:
                return checkSouth(currentView);
            case WEST:
                return checkWest(currentView);
            default:
                return false;

        }
    }


    /**
     * Method below just iterates through the list and check in the correct coordinates.
     * i.e. Given your current position is 10,10
     * checkEast will check up to wallSensitivity amount of tiles to the right.
     * checkWest will check up to wallSensitivity amount of tiles to the left.
     * checkNorth will check up to wallSensitivity amount of tiles to the top.
     * checkSouth will check up to wallSensitivity amount of tiles below.
     */
    private boolean checkEast(HashMap<Coordinate, MapTile> currentView){
        // Check tiles to my right
        Coordinate currentPosition = new Coordinate(controller.getPosition());
        for(int i = 0; i <= wallSensitivity; i++){
            MapTile tile = currentView.get(new Coordinate(currentPosition.x+i, currentPosition.y));
            if(tile.isType(MapTile.Type.WALL) || tile instanceof LavaTrap){
                return true;
            }
        }
        return false;
    }

    private boolean checkWest(HashMap<Coordinate,MapTile> currentView){
        // Check tiles to my left
        Coordinate currentPosition = new Coordinate(controller.getPosition());
        for(int i = 0; i <= wallSensitivity; i++){
            MapTile tile = currentView.get(new Coordinate(currentPosition.x-i, currentPosition.y));
            if(tile.isType(MapTile.Type.WALL) || tile instanceof LavaTrap){
                return true;
            }
        }
        return false;
    }

    private boolean checkNorth(HashMap<Coordinate,MapTile> currentView){
        // Check tiles to towards the top
        Coordinate currentPosition = new Coordinate(controller.getPosition());
        for(int i = 0; i <= wallSensitivity; i++){
            MapTile tile = currentView.get(new Coordinate(currentPosition.x, currentPosition.y+i));
            if(tile.isType(MapTile.Type.WALL) || tile instanceof LavaTrap){
                return true;
            }
        }
        return false;
    }

    private boolean checkSouth(HashMap<Coordinate,MapTile> currentView){
        // Check tiles towards the bottom
        Coordinate currentPosition = new Coordinate(controller.getPosition());
        for(int i = 0; i <= wallSensitivity; i++){
            MapTile tile = currentView.get(new Coordinate(currentPosition.x, currentPosition.y-i));
            if(tile.isType(MapTile.Type.WALL) || tile instanceof LavaTrap){
                return true;
            }
        }
        return false;
    }

}
