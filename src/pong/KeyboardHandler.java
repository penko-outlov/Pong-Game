package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class that handles the player controls from the keyboard.
 * @author Penko Outlov
 */
public class KeyboardHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                Game.canvas.playerOne.moveUp(Game.canvas.PADDLE_SPEED);
                break;
            case KeyEvent.VK_S:
                Game.canvas.playerOne.moveDown(Game.canvas.PADDLE_SPEED);
                break;
            case KeyEvent.VK_UP:
                Game.canvas.playerTwo.moveUp(Game.canvas.PADDLE_SPEED);
                break;
            case KeyEvent.VK_DOWN:
                Game.canvas.playerTwo.moveDown(Game.canvas.PADDLE_SPEED);
                break;
            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
