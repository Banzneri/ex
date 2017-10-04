import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDrawingAreaComponent extends JPanel {
    private int xPos;
    private int yPos;

    public MyDrawingAreaComponent() {
        xPos = 100;
        yPos = 100;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(xPos, yPos, 50, 50);
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
        repaint();
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
        repaint();
    }
}