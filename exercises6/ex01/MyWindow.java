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
        HandleButtonClick buttonHandler = new HandleButtonClick();

        button.addActionListener(this);
        button2.addActionListener(this);
        drawingArea.addMouseListener(new MyMouseListener());

        add(button, BorderLayout.PAGE_START);
        add(button2, BorderLayout.PAGE_END);
        add(drawingArea, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button)) {
            System.out.println("Ok");
        } else if(e.getSource().equals(button2)) {
            System.out.println("Cancel");
        }
    }

    class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("X: " + e.getX() + " Y: " + e.getY());
        }
    }
}