public class Player {
    private int x, y;
    private int width, height;
    private int velocity;

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = 0;
    }

    public void moveLeft() {
        x -= velocity;
    }

    public void moveRight() {
        x += velocity;
    }

    public void jump() {
        // Add jump logic here
    }

    public void update() {
        // Update player state
    }

    public void land() {
        // Logic for landing
    }

    public boolean isColliding(Player other) {
        // Collision detection logic
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void resetPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}