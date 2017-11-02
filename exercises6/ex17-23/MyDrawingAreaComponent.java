import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyDrawingAreaComponent extends JPanel {
    private PlayerCircle playerCircle;
    private EnemyCircle enemyCircle;
    private ArrayList<MyCircle> circles;
    private int spawnIntervalInSeconds;
    private Timer spawnTimer;
    private long resultStartTime;
    private long resultTime;
    private JLabel scoreLabel;
    private String playerName;
    private boolean gameOn;
    private Thread loop;

    private MyWindow host;

    public MyDrawingAreaComponent(MyWindow host) {
        this.host = host;
        circles = new ArrayList<>();
        spawnIntervalInSeconds = 10;
        resultTime = 0;
        scoreLabel = new JLabel(getResultAsString());

        add(scoreLabel, BorderLayout.SOUTH);
    }
    
    /**
     * Starts the game; initializes the spawnStartTime attribute,
     * adds the first EnemyCircle, and starts the thread which moves
     * the EnemyCircles
     */
    public void startGame(String playerName) {
        startTimers();
        gameOn = true;
        addMouseMotionListener(new MyMouseListener(this));
        this.playerName = playerName;
        playerCircle = new PlayerCircle(this);
        enemyCircle = new EnemyCircle(this);
        resultStartTime = System.nanoTime();
        circles.add(playerCircle);
        circles.add(enemyCircle);
        loop = new Thread(this::update);
        loop.start();
    }

    public void endGame() {
        Highscore score = new Highscore();
        score.writeHighScore(getPlayerName(), getResultTimeInSeconds());
        gameOn = false;
        host.endGame();
    }

    public void startTimers() {
        spawnTimer = new Timer(spawnIntervalInSeconds * 1000, e -> spawnEnemies());
        spawnTimer.start();
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
    }

    public void movePlayer(int x, int y) {
        playerCircle.setX(x);
        playerCircle.setY(y);
    }

    public void moveEnemies() {
        for(MyCircle circle : circles) {
            circle.move();
            if(circle.isCollision(playerCircle) && !circle.equals(playerCircle)) {
                System.out.println("Collision");
                endGame();
            }
        }
    }

    public void update() {
        while(gameOn) {
            moveEnemies();
            handleScore();
            repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void spawnEnemies() {
        circles.add(new EnemyCircle(this));
    }

    public void handleScore() {
        resultTime = System.nanoTime() - resultStartTime;
        scoreLabel.setText(getResultAsString());
    }

    public int getResultTimeInSeconds() {
        return (int) ((double) resultTime / 1000000000.0);
    }

    public String getResultAsString() {
        return Integer.toString(getResultTimeInSeconds());
    }

    public String getPlayerName() {
        return playerName;
    }
}