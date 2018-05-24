package mycontroller.tactics;

import controller.CarController;
import mycontroller.datastructure.Node;
import tiles.LavaTrap;
import tiles.MapTile;
import utilities.Coordinate;
import world.World;
import world.WorldSpatial;

import java.util.HashMap;
import java.util.Stack;

public class Driver {
    // Car properties
    private CarController controller;
    private Stack<Node> solution;
    Coordinate destination;
    private static final int CAR_SPEED = 4;
    private static final int DISTANCE_FROM_WALL = 4;

    // Car Physics
    WorldSpatial.Direction currentOrientation;
    WorldSpatial.Direction nextDirection;
    float angle;
    Coordinate currentTile;
    Coordinate nextTile;

    // Turns and paths
    private boolean onPath = false;
    private WorldSpatial.RelativeDirection lastDirectionTurn = null;
    private boolean isTurningLeft = false;
    private boolean isTurningRight = false;
    private WorldSpatial.Direction previous = null;

    private static final int EAST_DIFFERENCE = 3;

    public Driver(CarController controller, Stack<Node> solution) {
        this.controller = controller;
        this.solution = solution;
    }

    private WorldSpatial.RelativeDirection getDirection(WorldSpatial.Direction orientation,
                                                        Coordinate currentTile,
                                                        Coordinate nextTile) {
        int x = nextTile.x - currentTile.x;
        int y = nextTile.y - currentTile.y;

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

    private void applyLeftTurn(WorldSpatial.Direction orientation, float delta) {
        switch(orientation) {
            case NORTH:
                if (!controller.getOrientation().equals(WorldSpatial.Direction.WEST)) {
                    controller.turnLeft(delta);
                }
                break;
            case SOUTH:
                if (!controller.getOrientation().equals(WorldSpatial.Direction.EAST)) {
                    controller.turnLeft(delta);
                }
                break;
            case EAST:
                if (!controller.getOrientation().equals(WorldSpatial.Direction.NORTH)) {
                    controller.turnLeft(delta);
                }
                break;
            case WEST:
                if (!controller.getOrientation().equals(WorldSpatial.Direction.SOUTH)) {
                    controller.turnLeft(delta);
                }
                break;
            default:
                break;
        }
    }

    private void applyRightTurn(WorldSpatial.Direction orientation, float delta) {
        switch(orientation) {
            case NORTH:
                if (!controller.getOrientation().equals(WorldSpatial.Direction.EAST)) {
                    controller.turnRight(delta);
                }
                break;
            case SOUTH:
                if (!controller.getOrientation().equals(WorldSpatial.Direction.WEST)) {
                    controller.turnRight(delta);
                }
                break;
            case EAST:
                if (!controller.getOrientation().equals(WorldSpatial.Direction.SOUTH)) {
                    controller.turnRight(delta);
                }
                break;
            case WEST:
                if (!controller.getOrientation().equals(WorldSpatial.Direction.NORTH)) {
                    controller.turnRight(delta);
                }
                break;
            default:
                break;
        }
    }

    private void readJust(WorldSpatial.RelativeDirection lastDirectionTurn, float delta) {
        if (lastDirectionTurn == null) {
            return;
        }
        if (isTurningRight && lastDirectionTurn.equals(WorldSpatial.RelativeDirection.RIGHT)) {
            adjustRight(controller.getOrientation(), delta);
        } else if (!isTurningLeft && lastDirectionTurn.equals(WorldSpatial.RelativeDirection.LEFT)) {
            adjustLeft(controller.getOrientation(), delta);
        }
    }

    private void adjustLeft(WorldSpatial.Direction orientation, float delta) {
        switch(orientation) {
            case NORTH:
                if (controller.getAngle() > WorldSpatial.NORTH_DEGREE) {
                    controller.turnRight(delta);
                }
                break;
            case SOUTH:
                if (controller.getAngle() > WorldSpatial.SOUTH_DEGREE) {
                    controller.turnRight(delta);
                }
                break;
            case EAST:
                if (controller.getAngle() > WorldSpatial.EAST_DEGREE_MIN + EAST_DIFFERENCE) {
                    controller.turnRight(delta);
                }
                break;
            case WEST:
                if (controller.getAngle() > WorldSpatial.WEST_DEGREE) {
                    controller.turnRight(delta);
                }
                break;
            default:
                break;
        }
    }

    private void adjustRight(WorldSpatial.Direction orientation, float delta) {
        switch(orientation) {
            case NORTH:
                if (controller.getAngle() < WorldSpatial.NORTH_DEGREE) {
                    controller.turnLeft(delta);
                }
                break;
            case SOUTH:
                if (controller.getAngle() < WorldSpatial.SOUTH_DEGREE) {
                    controller.turnLeft(delta);
                }
                break;
            case EAST:
                if (controller.getAngle() > WorldSpatial.SOUTH_DEGREE && controller.getAngle() < WorldSpatial.EAST_DEGREE_MAX) {
                    controller.turnLeft(delta);
                }
                break;
            case WEST:
                if (controller.getAngle() < WorldSpatial.WEST_DEGREE) {
                    controller.turnLeft(delta);
                }
                break;
            default:
                break;
        }
    }

    private boolean checkNorth(HashMap<Coordinate, MapTile> currentView) {
        Coordinate currentPosition = new Coordinate(controller.getPosition());
        for (int i = 0; i < DISTANCE_FROM_WALL; i++) {
            MapTile tile = currentView.get(new Coordinate(currentPosition.x, currentPosition.y+i));
            if (tile.isType(MapTile.Type.WALL) || tile instanceof LavaTrap) {
                return true;
            }
        }

        return false;
    }

}
