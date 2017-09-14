package com.mycompany.app;

import java.util.ArrayList;

/**
 * The class for the board in game
 * 
 */
public class Board {
    /**
     * All the spots on the board
     */
    ArrayList<Spot> spots = new ArrayList<>();

    /**
     * The total number of spots on the board
     */
    int numberOfSpots = 16;

    /**
     * All the players
     */
    ArrayList<Player> players;

    /**
     * Constructor of Board
     * 
     * @param players A list of all the players
     */
    public Board(ArrayList<Player> players) {
        this.players = players;
        initSpots();
        initCards();
    }

    /**
     * Returns a string of all the spots on the board
     */
    public String draw() {
        String toDraw = "";
        for(Spot spot : spots) {
            toDraw += spot.draw();
        }
        return toDraw;
    }

    /**
     * Initiates the spots list, adding all the players into the
     * first spot
     */
    public void initSpots() {
        for(int i = 1; i < numberOfSpots + 1; i++) {
            spots.add(new Spot(i));
        }

        spots.get(0).flipCard();
        spots.get(numberOfSpots - 1).flipCard();

        for(Player player : players) {
            spots.get(0).addPlayer(player);
        }
    }

    /**
     * Adds a card to all the spots
     */
    public void initCards() {
        for(Spot spot : spots) {
            spot.setCard(new Card(this));
        }
    }

    /**
     * Sets the player position, adding the player to the correct
     * spot on the board
     * 
     * @param startPos the position from where the player came
     * @param endPos the position where the player moved to
     * @param player the player object
     */
    public void setPlayerPosition(int startPos, int endPos, Player player) {
        if(endPos >= numberOfSpots - 1) {
            spots.get(startPos).removePlayer(player);
            spots.get(numberOfSpots - 1).addPlayer(player);
            System.out.println(player.getName() + " voitti pelin!");
            System.exit(1);
        } else if(startPos != endPos) {
            player.setSpotNumber(endPos);
            spots.get(startPos).removePlayer(player);
            spots.get(endPos).addPlayer(player);
        }
    }
}