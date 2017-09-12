package com.mycompany.app;

import java.util.ArrayList;

public class Board {
    ArrayList<Spot> spots = new ArrayList<>();
    int numberOfSpots = 16;
    ArrayList<Player> players;

    public Board(ArrayList<Player> players) {
        this.players = players;
        initSpots();
        initCards();
    }

    public String draw() {
        String toDraw = "";
        for(Spot spot : spots) {
            toDraw += spot.draw();
        }
        return toDraw;
    }

    public String drawCards() {
        String toDraw = "";
        for(Spot spot : spots) {
            toDraw += spot.hasCard() ? " T " : " F "; 
        }
        return toDraw;
    }

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

    public void initCards() {
        for(Spot spot : spots) {
            spot.setCard(new Card(this));
        }
    }

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