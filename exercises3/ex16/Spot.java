package ex15;
import java.util.ArrayList;
import ex15.*;

public class Spot {
    int number;
    ArrayList<Player> players = new ArrayList<>();
    Card card;
    
    public Spot(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Card getCard() {
        return card;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void draw() {
        String toDraw = " [ ";
        for(Player player : players) {
            toDraw += player.getName();
        }
        toDraw += " ] ";
    }
}