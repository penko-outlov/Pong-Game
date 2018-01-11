package pong;

import java.awt.Color;

/**
 * The paddle class is used to represent the two players in the game
 * on the left and right side of the field.
 * @author Penko Outlov
 */
public class Paddle extends GameObject {
    private int width;
    private int height;
    private int points = 0;

    /**
     * Constructor
     * @param x the x coordinate
     * @param y the y coordinate
     * @param color the color of the paddle
     */
    public Paddle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        width = 20;
        height = 135;
        objectColor = color;
    }

    /**
     * Constructor
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width of the paddle
     * @param height the height of the paddle
     * @param color the color of the paddle
     */
    public Paddle(int x, int y, int width, int height, Color color) {
        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
        objectColor = color;
    }

    /**
     * Gets the width of the paddle
     * @return width of the paddle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the paddle
     * @param width the width of the paddle
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the height of the paddle
     * @return the height of the paddle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the paddle
     * @param height the height of the paddle
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets the points that the player has earned
     * @return the amount of points that the player has
     */
    public int getPoints() {
        return points;
    }

    /**
     * Adds one point to the point total of the player
     */
    public void addPoint() {
        points++;
    }

    /**
     * Moves the player up the screen
     * @param amount the amount with which to move the player up the screen
     */
    public void moveUp(int amount) {
        if (y - amount >= -10) {
            y -= amount;
        }
    }

    /**
     * Moves the player up the screen
     * @param amount the amount with which to move the player up the screen
     */
    public void moveDown(int amount) {
        if (y + amount <= Game.GAME_HEIGHT - height - 15) {
            y += amount;
        }
    }
}
