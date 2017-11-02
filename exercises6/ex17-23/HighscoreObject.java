public class HighscoreObject implements Comparable<HighscoreObject> {
    private String name;
    private int score;

    public HighscoreObject(String name, int score) {
        this.name = name;
        this.score = score;
    } 

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int compareTo(HighscoreObject compareObject) {        
        return Integer.compare(compareObject.getScore(), getScore());
    }
}