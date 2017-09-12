package ex15;

import ex15.*;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    int spotNumber = 0;
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

    public int throwDice() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    public void doTurn() {
        System.out.println(name + " turn, press enter to throw die: ");
        Scanner scan = new Scanner(System.in);
        spotNumber += throwDice();
    }
}