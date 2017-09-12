package com.mycompany.app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<Player> players = new ArrayList<>();
    Board board;
    boolean gameOn = true;

    public static void main(String[] args) {
        App game = new App();
        game.initPlayers();
        game.initBoard();
        game.start();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void initPlayers() {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many players? (1-5): ");
        int number = scan.nextInt();
        for(int i = 0; i < number; i++) {
            players.add(new Player("p" + (i+1)));
        }
    }

    public void initBoard() {
        board = new Board(players);
    }

    public Board getBoard() {
        return board;
    }

    public void start() {
        while(gameOn) {
            handleTurns();
        }
    }

    public void handleTurns() {
        for(Player player : players) {
            draw();
            player.doTurn(getBoard());
        }
    }

    public void draw() {
        System.out.println(board.draw());
        System.out.println(board.drawCards());
    }


}