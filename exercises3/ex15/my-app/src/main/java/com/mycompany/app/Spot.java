package com.mycompany.app;

import java.util.ArrayList;

/**
 * Class for the spots on the board
 */
public class Spot {
    /**
     * The number where the spot is located on the board
     */
    int number;

    /**
     * A list of all players on this spot
     */
    ArrayList<Player> players = new ArrayList<>();

    /**
     * The card for this spot
     */
    Card card;

    /**
     * Boolean determining if the spot has a card, defaults to true
     */
    boolean hasCard = true;
    
    /**
     * Constructor for Spot
     * 
     * @param number The place on the board
     */
    public Spot(int number) {
        this.number = number;
    }

    /**
     * Returns the number where the spot is placed on the board
     * 
     * @return the position number of the spot
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the card of this spot
     * 
     * @return the card object of the spot
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets the card of this spot
     * 
     * @param card the card object
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * Returns the value of hasCard variable
     * 
     * @return true if spot still has card, false otherwise
     */
    public boolean hasCard() {
        return hasCard;
    }

    /**
     * Flips the card when the player has activated the card,
     * makes hasCard variable false
     */
    public void flipCard() {
        hasCard = false;
    }

    /**
     * Adds a player to the spot, and activates the card action if the spot
     * still has a card
     * 
     * @param player the player object
     */
    public void addPlayer(Player player) {
        players.add(player);
        if(hasCard()) {
            getCard().doAction(player);
            flipCard();
        }
    }

    /**
     * Removes the player from the spot
     * 
     * @param player the player object
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

    /**
     * Return a list of all the players on this spot
     * 
     * @return the list of all the players in this spot
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Returns a string which represents the status of the spot,
     * including all the players
     * 
     * @return a String representation of this spot object
     */
    public String draw() {
        String toDraw = (hasCard() && players.size() == 0) ? " [x" : " [ ";
        for(Player player : players) {
            toDraw += player.getName() + " ";
        }
        toDraw += "] ";
        return toDraw;
    }
}