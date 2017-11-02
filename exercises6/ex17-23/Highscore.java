import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Highscore {
    private ArrayList<HighscoreObject> list;

    public Highscore() {
        loadHighscore();
    }

    public void loadHighscore() {
        ArrayList<HighscoreObject> hs = new ArrayList<>();
        Path file = Paths.get("score.txt");
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(file);   
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(String string : lines) {
            String[] arr = string.split(";");
            for(String str : arr) {
                String name = str.split(":")[0];
                int score = Integer.parseInt(str.split(":")[1]);
                hs.add(new HighscoreObject(name, score));
            }
        }

        Collections.sort(hs);

        list = hs;
    }

    public void writeHighScore(String name, int score) {
        String string = name + ":" + Integer.toString(score) + ";";
        Path file = Paths.get("score.txt");
        boolean found = false;

        
        for(HighscoreObject o : list) {
            if(o.getName().equals(name) && o.getScore() < score) {
                write(file, string);
                found = true;
            }
        }

        if(!found) {
            write(file, string);
        }
    }

    public ArrayList<HighscoreObject> getHighscoreList() {
        return list;
    }

    public void write(Path file, String string) {
        try {
            Files.write(file, string.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}