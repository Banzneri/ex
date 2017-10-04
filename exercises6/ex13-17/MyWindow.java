import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyWindow extends JFrame implements ActionListener {
    private JButton button;
    private JButton button2;
    private MyDrawingAreaComponent drawingArea;

    public MyWindow() {
        button = new JButton("Ok");
        button2 = new JButton("Cancel");
        drawingArea = new MyDrawingAreaComponent();

        button.addActionListener(this);
        button2.addActionListener(this);
        drawingArea.addMouseMotionListener(new MyMouseListener(drawingArea));

        add(button, BorderLayout.PAGE_START);
        add(button2, BorderLayout.PAGE_END);
        add(drawingArea, BorderLayout.CENTER);

        Thread thread = new Thread(this::moveCircles);
        thread.start();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button)) {
            System.out.println("Ok");
        } else if(e.getSource().equals(button2)) {
            System.out.println("Cancel");
        }
    }

    public void moveCircles() {
        while(true) {
            drawingArea.setXPos(drawingArea.getXPos() + 1);
            repaint();
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}