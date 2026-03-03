import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    private boolean isLeftPressed = false;
    private boolean isRightPressed = false;
    private boolean isJumpPressed = false;

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            isLeftPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isRightPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isJumpPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            isLeftPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isRightPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isJumpPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public boolean isLeftPressed() {
        return isLeftPressed;
    }

    public boolean isRightPressed() {
        return isRightPressed;
    }

    public boolean isJumpPressed() {
        return isJumpPressed;
    }
}