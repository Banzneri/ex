import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyDrawingAreaComponent extends JPanel {
    private PlayerCircle playerCircle;
    private EnemyCircle enemyCircle;
    private ArrayList<MyCircle> circles;
    private long spawnStartTime;
    private long spawnCounterInNanoSeconds;
    private int spawnIntervalInSeconds;

    public MyDrawingAreaComponent() {
        playerCircle = new PlayerCircle(this);
        enemyCircle = new EnemyCircle(this);
        circles = new ArrayList<>();

        spawnStartTime = System.nanoTime();
        spawnCounterInNanoSeconds = 0;
        spawnIntervalInSeconds = 10;

        circles.add(playerCircle);
    }

    public void startGame() {
        circles.add(enemyCircle);
        Thread thread = new Thread(this::moveCircles);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(MyCircle circle : circles) {
            g.setColor(circle.getColor());
            g.fillOval(circle.getX(), 
                        circle.getY(),
                        circle.getRadius()*2,
                        circle.getRadius()*2);
            repaint();
        }
        spawnEnemies();
    }

    public void movePlayer(int x, int y) {
        playerCircle.setX(x);
        playerCircle.setY(y);
    }

    public void moveEnemies() {
        for(MyCircle circle : circles) {
            circle.move();
            if(circle.isCollision(playerCircle) && !circle.equals(playerCircle)) {
                System.exit(0);
            }
        }
    }

    public void moveCircles() {
        while(true) {
            moveEnemies();
            repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void spawnEnemies() {
        spawnCounterInNanoSeconds = System.nanoTime() - spawnStartTime;
        if((double) spawnCounterInNanoSeconds / 1000000000.0 > spawnIntervalInSeconds) {
            circles.add(new EnemyCircle(this));
            spawnCounterInNanoSeconds = 0;
            spawnStartTime = System.nanoTime();
        } 
    }
}