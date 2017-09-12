package com.mycompany.app;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    int spotNumber = 0;
    int previousThrow = 0;
    String name;

    public Player(String name) {
        this.name = name;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public String getName() {
        return name;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public int getPreviousThrow() {
        return previousThrow;
    }

    public void setPreviousThrow(int previousThrow) {
        this.previousThrow = previousThrow;
    }

    public int throwDice() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

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