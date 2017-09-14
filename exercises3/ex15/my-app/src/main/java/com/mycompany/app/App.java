package com.mycompany.app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class
 */
public class App {
    /**
     * A list of all the players
     */
    ArrayList<Player> players = new ArrayList<>();
    /**
     * Boolean for the main loop in start() method
     */
    boolean gameOn = true;
    /**
     * The game board object
     */
    Board board;

    /**
     * The main method. Initializes and starts the game
     */
    public static void main(String[] args) {
        App game = new App();
        game.initPlayers();
        game.initBoard();
        game.start();
    }

    /**
     * Returns the player list
     * 
     * @return the players ArrayList
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Asks the user how many players (1-5),
     * and initializes the players list
     */
    public void initPlayers() {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many players? (1-5): ");
        int number = scan.nextInt();
        for(int i = 0; i < number; i++) {
            players.add(new Player("p" + (i+1)));
        }
    }

    /**
     * Initializes the game board
     */
    public void initBoard() {
        board = new Board(players);
    }

    /**
     * Returns the game board object
     * 
     * @return the game board object
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Starts the main game loop
     */
    public void start() {
        while(gameOn) {
            handleTurns();
        }
    }

    /**
     * Handles the player turns, and draws the board
     */
    public void handleTurns() {
        for(Player player : players) {
            draw();
            player.doTurn(getBoard());
        }
    }

    /**
     * Draws the game board
     */
    public void draw() {
        System.out.println(board.draw());
    }


}