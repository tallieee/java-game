import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements Runnable {
    private Player player;
    private InputHandler inputHandler;
    private List<Platform> platforms;
    private Thread gameThread;
    private boolean isRunning;

    public GamePanel() {
        setBackground(Color.CYAN);
        setFocusable(true);
        player = new Player(100, 100);
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        platforms = new ArrayList<>();
        platforms.add(new Platform(0, 550, 800, 50));
        platforms.add(new Platform(150, 450, 200, 20));
        platforms.add(new Platform(500, 400, 200, 20));
        platforms.add(new Platform(200, 300, 200, 20));
        platforms.add(new Platform(500, 200, 200, 20));
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (isRunning) {
            update();
            repaint();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        if (inputHandler.isLeftPressed()) {
            player.moveLeft();
        }
        if (inputHandler.isRightPressed()) {
            player.moveRight();
        }
        if (inputHandler.isJumpPressed()) {
            player.jump();
        }
        player.update();
        for (Platform platform : platforms) {
            if (player.isColliding(platform)) {
                player.land();
            }
        }
        if (player.getY() > getHeight()) {
            player.resetPosition();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        for (Platform platform : platforms) {
            g2d.fillRect(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());
        }
        g2d.setColor(Color.RED);
        g2d.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }
}