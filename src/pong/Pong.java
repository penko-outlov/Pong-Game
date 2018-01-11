package pong;

import javax.swing.SwingUtilities;

/**
 * The Pong class is the entry point for game
 * @author Penko Outlov
 */
public class Pong {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Game().start();
        });
    }
}
