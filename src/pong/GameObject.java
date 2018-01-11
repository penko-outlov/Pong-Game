package pong;

import java.awt.Color;

/**
 * A class which models an object that is used in the game
 * @author Penko Outlov
 */
public class GameObject {
    protected int x;
    protected int y;
    protected Color objectColor = Color.BLACK;

    /**
     * Gets the x position of the object
     * @return x position of the object
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x position of the object
     * @param x the x coordinate
     */
    public void setX(int x) {
        if (x > 0) {
            this.x = x;
        } else {
            this.x = 0;
            System.err.println("Coordinates have to be a positive number");
        }
    }

    /**
     * Gets the y position of the object
     * @return y position of the object
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y position of the object
     * @param y the x coordinate
     */
    public void setY(int y) {
        if (y > 0) {
            this.y = y;
        } else {
            this.y = 0;
            System.err.println("Coordinates have to be a positive number");
        }
    }

    /**
     * Gets the color of the object
     * @return color of the object
     */
    public Color getObjectColor() {
        return objectColor;
    }

    /**
     * Sets the object color
     * @param objectColor the desired color of the object
     */
    public void setObjectColor(Color objectColor) {
        this.objectColor = objectColor;
    }

    /**
     * Sets the x and y coordinate of the object
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setLocation(int x, int y) {
        setX(x);
        setY(y);
    }
}
