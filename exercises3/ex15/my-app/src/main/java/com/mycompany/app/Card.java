package com.mycompany.app;

import java.util.concurrent.ThreadLocalRandom;

public class Card {
    int randomEffect;
    Board board;

    public Card(Board board) {
        randomEffect = ThreadLocalRandom.current().nextInt(1, 4);
        this.board = board;
    }

    public void doAction(Player player) {
        switch(randomEffect) {
            case 1: backToFirst(player);
                    break;
            case 2: doubleMove(player);
                    break;
            case 3: empty(player);
        }
    }

    public void backToFirst(Player player) {
        System.out.println("Back to first spot! Sorry!");
        board.setPlayerPosition(player.getSpotNumber(), 0, player);
    }

    public void doubleMove(Player player) {
        System.out.println("Double movement!");
        int endPoint = player.getSpotNumber() + player.getPreviousThrow();
        board.setPlayerPosition(player.getSpotNumber(), endPoint, player);
    }

    public void empty(Player player) {
        System.out.println("Empty card!");
    }
}