import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDrawingAreaComponent extends JPanel {
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(50, 50, 50, 50);
    }
}