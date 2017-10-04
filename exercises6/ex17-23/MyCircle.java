import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class MyCircle {
    private int x;
    private int y;
    private int radius;
    private int velocityX;
    private int velocityY;
    private Color color;
    private MyDrawingAreaComponent host;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        if(x < 0 || x > host.getWidth()) {
            setVelocityX(-getVelocityX());
            if(this.x < 0) {
                this.x = 0;
            } else  {
                this.x = host.getWidth();
            }
        }
    } 

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        if(y < 0 || y > host.getHeight()) {
            setVelocityY(-getVelocityY());
            if(this.y < 0) {
                this.y = 0;
            } else  {
                this.y = host.getHeight();
            }
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyDrawingAreaComponent getHost() {
        return host;
    }

    public void setHost(MyDrawingAreaComponent host) {
        this.host = host;
    }

    public int getRandom(int least, int bound) {
        return ThreadLocalRandom.current().nextInt(least, bound);
    }

    public void move() { }

    public boolean isCollision(MyCircle circle) {
        int dx = getCenterX() - circle.getCenterX();
        int dy = getCenterY() - circle.getCenterY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if(distance < getRadius() + circle.getRadius()) {
            return true;
        }

        return false;
    }

    public int getCenterX() {
        return getX() + getRadius();
    }

    public int getCenterY() {
        return getY() + getRadius();
    }
}