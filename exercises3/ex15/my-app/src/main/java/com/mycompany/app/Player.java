package com.mycompany.app;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The player class
 */
public class Player {
    /**
     * The position of the player on the board,
     * defaults to 0, where all players start
     */
    int spotNumber = 0;
    /**
     * Keeps track of the previous die throw result,
     * used in DoubleMove() method of Card
     */
    int previousThrow = 0;
    /**
     * The name of the player; works as a visual representation
     * of the player on the board when drawing
     */
    String name;

    /**
     * Constructor for Player
     * 
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the position number of the player
     * 
     * @return the position number of the player
     */
    public int getSpotNumber() {
        return spotNumber;
    }

    /**
     * Sets the position number of the player
     * 
     * @param spotNumber the position number of the player
     */
    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    /**
     * Returns the name of the player
     * 
     * @return the name of the player
     */
    public String getName() {
        return name;
    } 

    /**
     * Sets the name of the player
     * 
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the previous throw result of the player
     * 
     * @return the previous throw result
     */
    public int getPreviousThrow() {
        return previousThrow;
    }

    /**
     * Sets the previous throw result
     * 
     * @param previousThrow the throw result of the player
     */
    public void setPreviousThrow(int previousThrow) {
        this.previousThrow = previousThrow;
    }

    /**
     * 'Throws dice', randomizes an integer from 1 to 6
     * 
     * @return a random integer from 1 to 6
     */
    public int throwDice() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    /**
     * Handles the turn of the player; throws die and sets player position
     * 
     * @param board the game board object
     */
    public void doTurn(Board board) {
        int startPos = getSpotNumber();
        System.out.print(name + " turn, press enter to throw die: ");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int result = throwDice();
        setPreviousThrow(result);
        System.out.println("You threw " + result);
        board.setPlayerPosition(startPos, startPos + result, this);
    }
}