package com.mycompany.app;

import java.util.ArrayList;

public class Spot {
    int number;
    ArrayList<Player> players = new ArrayList<>();
    Card card;
    boolean hasCard = true;
    
    public Spot(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean hasCard() {
        return hasCard;
    }

    public void flipCard() {
        hasCard = false;
    }

    public void addPlayer(Player player) {
        players.add(player);
        if(hasCard()) {
            getCard().doAction(player);
            flipCard();
        }
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String draw() {
        String toDraw = (hasCard() && players.size() == 0) ? " [x" : " [ ";
        for(Player player : players) {
            toDraw += player.getName() + " ";
        }
        toDraw += "] ";
        return toDraw;
    }
}