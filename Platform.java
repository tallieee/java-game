public class Platform {
    private int x;
    private int y;
    private int width;
    private int height;

    public Platform(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isColliding(Platform other) {
        return this.x < other.getX() + other.getWidth() &&
               this.x + this.width > other.getX() &&
               this.y < other.getY() + other.getHeight() &&
               this.y + this.height > other.getY();
    }
}