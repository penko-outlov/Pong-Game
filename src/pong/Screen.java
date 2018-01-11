package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The Display class is used to represent the core game logic and also to display the game objects to the user.
 *
 * @author Penko Outlov
 */
public class Screen extends JPanel implements Runnable {
    public Random generator = new Random();
    public static final int OFFSET = 10;
    public static final Color FONT_COLOR = new Color(237, 9, 130);
    public static final Font SCORE_FONT = new Font("Arial", Font.PLAIN, 24);

    public Ball gameBall;
    public Paddle playerOne;
    public Paddle playerTwo;
    private String score;
    private boolean isRunning = true;
    private final int GAME_SPEED = 30;
    private int xSpeed = 10;
    private int ySpeed = 10;
    public final int PADDLE_SPEED = 15;
    public int acceleration = 0;

    /**
     * Constructor
     *
     * @param width of the graphics window
     * @param height of the graphics window
     */
    public Screen(int width, int height) {
        setSize(width, height);
        initGameObjects();
    }

    /**
     * Updates the graphics of the game window using simple double buffering.
     */
    public void updateGraphics() {
        Image updatedView = createImage(getWidth(), getHeight());
        Graphics updatedGraphics = updatedView.getGraphics();
        drawGameObjects(updatedGraphics);
        getGraphics().drawImage(updatedView, 0, 0, null);
    }


    // Used to initialize the paddle for player one, the paddle for player two and the game ball.
    private void initGameObjects() {
        gameBall = new Ball(getWidth() / 2, getHeight() / 2, Color.RED);
        playerOne = new Paddle(20, getHeight() / 2 - 75 - OFFSET, Color.GREEN);
        playerTwo = new Paddle(getWidth() - 40, getHeight() / 2 - 75 - OFFSET, Color.BLUE);
        score = playerOne.getPoints() + " : " + playerTwo.getPoints();
    }

    private void drawGameObjects(Graphics g) {
        g.setColor(FONT_COLOR);
        g.setFont(SCORE_FONT);
        g.drawString(score, getWidth() / 2 - 2 * OFFSET, 10 + OFFSET);
        g.setColor(gameBall.getObjectColor());
        g.fillOval(gameBall.getX(), gameBall.getY(), gameBall.getDiameter(), gameBall.getDiameter());
        g.setColor(playerOne.objectColor);
        g.fillRect(playerOne.getX(), playerOne.getY(), playerOne.getWidth(), playerOne.getHeight());
        g.setColor(playerTwo.objectColor);
        g.fillRect(playerTwo.getX(), playerTwo.getY(), playerTwo.getWidth(), playerTwo.getHeight());
    }

    private void checkCollision() {
        // Check to see if the ball has collided with one of the paddles
        if (gameBall.getX() <= playerOne.getX() + playerOne.getWidth() && gameBall.getY() >= playerOne.getY()
                && gameBall.getY() <= playerOne.getY() + playerOne.getHeight()) {
            acceleration++;
            xSpeed = -(xSpeed - acceleration);
            increaseVerticalSpeed();
        } else if (gameBall.getX() >= playerTwo.getX() - gameBall.getDiameter() && gameBall.getY() >= playerTwo.getY()
                && gameBall.getY() <= playerTwo.getY() + playerTwo.getHeight()) {
            acceleration++;
            xSpeed = -(xSpeed + acceleration);
            increaseVerticalSpeed();
        }

        // Check to see if the ball has collided with the top or bottom of the screen
        if (gameBall.getY() <= 0) {
            ySpeed = -ySpeed;
        } else if (gameBall.getY() >= getHeight() - gameBall.getDiameter()) {
            ySpeed = -ySpeed;
        }

        // Check to see if the ball has collided with the left or right side of the screen
        if (gameBall.getX() <= 0) {
            playerTwo.addPoint();
            gameBall.setX(getWidth() * 3 / 4 + generator.nextInt(25) + 1);
            xSpeed = -10;
            startNewRound();
        } else if (gameBall.getX() >= getWidth() - gameBall.getDiameter()) {
            playerOne.addPoint();
            gameBall.setX(getWidth() / 4 + generator.nextInt(25) + 1);
            xSpeed = 10;
            startNewRound();
        }
    }

    private void increaseVerticalSpeed() {
        if (ySpeed > 0) {
            ySpeed += acceleration;
        } else {
            ySpeed -= acceleration;
        }
    }

    private void startNewRound() {
        score = playerOne.getPoints() + " : " + playerTwo.getPoints();
        gameBall.setY(getHeight() / 4 + generator.nextInt(25) + 1);
        playerOne.setLocation(20, getHeight() / 2 - 75 - OFFSET);
        playerTwo.setLocation(getWidth() - 40, getHeight() / 2 - 75 - OFFSET);
        ySpeed = 10;
        acceleration = 0;
    }

    private void checkIfWon() {
        if (playerOne.getPoints() == 5 || playerTwo.getPoints() == 5) {
            isRunning = false;
        }
    }

    private String getWinner() {
        String winner;
        if (playerOne.getPoints() > playerTwo.getPoints()) {
            winner = "Player one wins!";
        } else {
            winner = "Player two wins!";
        }
        return winner + " Do you want to play again?";
    }

    private void showEndGameDialog() {
        int playerChoice = JOptionPane.showConfirmDialog(this, getWinner(), "Game Over", JOptionPane.YES_NO_CANCEL_OPTION);
        if (playerChoice == JOptionPane.YES_OPTION) {
            // TODO: restart the game
        } else {
            System.exit(0);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            gameBall.moveHorizontally(xSpeed);
            gameBall.moveVertically(ySpeed);
            checkCollision();
            checkIfWon();
            updateGraphics();
            try {
                Thread.sleep(GAME_SPEED); // This needs to be optimized
            } catch (InterruptedException ex) {
                System.err.println("Could not sleep the game thread.");
            }
        }
        showEndGameDialog();
    }
}
