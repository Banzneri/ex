package ex15;

import java.util.Scanner;
import ex15.*;

public class App {
    Player[] players;
    Board board;
    boolean gameOn = true;

    public static void main(String[] args) {
        initNumberOfPlayers();
        handleTurns();
    }

    public Player[] getPlayers() {
        return players;
    }

    public static void initNumberOfPlayers() {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many players? (1-5): ");
        int number = scan.nextInt();
        players = new Player[number];
    }

    public static void handleTurns() {
        while(gameOn) {
            for(Player player : players) {
                player.doTurn();
            }
        }
    }


}