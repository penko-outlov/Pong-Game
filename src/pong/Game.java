package pong;

import javax.swing.JFrame;

/**
 * Game window which handles the keyboard input from the user with an aspect ratio of 4:3
 * @author Penko Outlov
 */
public class Game extends JFrame {
    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = GAME_WIDTH / 4 * 3;
    public static final String GAME_NAME = "Pong Game";
    public static Screen canvas;
    public Thread gameThread;

    public Game() {
        setTitle(GAME_NAME);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(new KeyboardHandler());

        canvas = new Screen(GAME_WIDTH, GAME_HEIGHT);
        add(canvas);
    }

    /**
     * Starts the main game thread.
     */
    public synchronized void start() {
        gameThread = new Thread(canvas);
        gameThread.start();
    }
}
