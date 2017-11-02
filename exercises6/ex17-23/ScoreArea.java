import java.awt.Label;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JPanel;

public class ScoreArea extends JPanel {

    public ScoreArea() {
        drawScore();
    }

    public void drawScore() {
        Highscore score = new Highscore();
        ArrayList<HighscoreObject> hs = score.getHighscoreList();
        int count = 0;

        for(HighscoreObject o : hs) {
            count++;
            add(new Label(o.getName() + ": " + Integer.toString(o.getScore())));
            if(count == 5) {
                break;
            }
        }
    }
}