package com.mycompany.app;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The Card class
 */
public class Card {
    /**
     * A randomized integer from 1 to 3, giving the card a unique effect
     */
    int randomEffect;

    /**
     * The board object, given as a parameter to Card
     */
    Board board;

    /**
     * The constructor for Card
     * 
     * @param board The board object
     */
    public Card(Board board) {
        randomEffect = ThreadLocalRandom.current().nextInt(1, 4);
        this.board = board;
    }

    /**
     * Does an action on the player, depending on the randomEffect variable
     * 
     * @param player the player object
     */
    public void doAction(Player player) {
        switch(randomEffect) {
            case 1: backToFirst(player);
                    break;
            case 2: doubleMove(player);
                    break;
            case 3: empty(player);
        }
    }

    /**
     * Moves the player back to the first spot
     * 
     * @param player the player object
     */
    public void backToFirst(Player player) {
        System.out.println("Back to first spot! Sorry!");
        board.setPlayerPosition(player.getSpotNumber(), 0, player);
    }

    /**
     * Doubles the player movement
     * 
     * @param player the player object
     */
    public void doubleMove(Player player) {
        System.out.println("Double movement!");
        int endPoint = player.getSpotNumber() + player.getPreviousThrow();
        board.setPlayerPosition(player.getSpotNumber(), endPoint, player);
    }

    /**
     * Does nothing, notifies the player about an empty card
     * 
     * @param player the player object
     */
    public void empty(Player player) {
        System.out.println("Empty card!");
    }
}