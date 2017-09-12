package ex15;

import ex15.*;

public class Board {
    Spot[] spots = new Spot[32];

    public draw() {
        String toDraw = "";
        for(int i = 0; i < spots.length; i++) {
            System.out.print(spots[i].draw());
        }
    }
}