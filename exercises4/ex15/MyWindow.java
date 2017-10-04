import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyWindow extends JFrame {
    JButton button;
    JPanel panel;
    TextArea textArea;

    public MyWindow(String title, int width, int height) {
        button = new JButton("Clear");
        panel = new JPanel();
        textArea = new TextArea();

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(width, height);
        setTitle(title);

        panel.add(button);
        panel.add(textArea);
        add(panel);
        button.addActionListener(this::clearButtonClicked);
    }

    public void clearButtonClicked(ActionEvent e) {
        textArea.setText(" ");
        textArea.setText("");
    }
}
