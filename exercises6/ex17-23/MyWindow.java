import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyWindow extends JFrame {
    private JTextField nameField;
    private MyDrawingAreaComponent drawingArea;
    private ScoreArea scoreArea;
    private JButton scoreButton;

    public MyWindow() {
        nameField = new JTextField("MyName", 10);
        drawingArea = new MyDrawingAreaComponent(this);
        scoreArea = new ScoreArea();
        scoreButton = new JButton("Highscore");

        scoreButton.addActionListener(e -> showScore());
        nameField.addActionListener(e -> startGame());
        
        add(nameField, BorderLayout.NORTH);
        add(drawingArea, BorderLayout.CENTER);
        add(scoreArea, BorderLayout.SOUTH);
    }

    public void startGame() {
        nameField.setVisible(false);
        drawingArea.setVisible(true);
        drawingArea.startGame(nameField.getText());
    }

    public void endGame() {
        MyWindow window = new MyWindow();
        window.setTitle("MyTitle");
        window.setSize(500, 500);
        window.setVisible(true);
        this.dispose();
    }

    public void showScore() {
        
    }
}