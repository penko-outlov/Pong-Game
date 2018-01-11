package pong;

import java.awt.Color;

/**
 * The Ball class represents the ball that moves around the screen during the game.
 * @author Penko Outlov
 */
public class Ball extends GameObject {
    private int radius;

    /**
     * Constructor
     * @param x the x coordinate
     * @param y the y coordinate
     * @param color the color of the ball
     */
    public Ball(int x, int y, Color color) {
        setX(x);
        setY(y);
        radius = 12;
        objectColor = color;
    }

    /**
     * Constructor
     * @param radius the radius of the ball
     * @param color the color of the ball
     */
    public Ball(int radius, Color color) {
        setX(0);
        setY(0);
        setRadius(radius);
        objectColor = color;
    }

    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param radius the radius of the ball
     * @param color the color of the ball
     */
    public Ball(int x, int y, int radius, Color color) {
        setX(x);
        setY(y);
        setRadius(radius);
        objectColor = color;
    }

    /**
     * Gets the radius of the ball
     * @return radius of the ball
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the ball, which has to be over 10 pixel big
     * @param radius the radius of the ball
     */
    public void setRadius(int radius) {
        if (radius > 10) {
            this.radius = radius;
        } else {
            System.err.println("Radius has to be bigger than 10 pixels.");
        }
    }

    /**
     * Gets the diameter of the ball
     * @return diameter of the ball
     */
    public int getDiameter() {
        return radius * 2;
    }

    /**
     * Moves the ball on the x axis
     * @param amount with which the ball moves
     */
    public void moveHorizontally(int amount) {
        x += amount;
    }

    /**
     * Moves the ball on the y axis
     * @param amount with which the ball moves
     */
    public void moveVertically(int amount) {
        y += amount;
    }
}
