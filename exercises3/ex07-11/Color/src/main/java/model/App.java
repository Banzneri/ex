package model;

import java.util.LinkedHashSet;

import model.*;

public class App {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        LinkedHashSet<Point> pointSet = new LinkedHashSet<>();
        pointSet.add(new Point(5, 5));
        pointSet.add(new Point(6, 6));
        pointSet.add(new Point(7, 7));
        pointSet.add(new Point(8, 8));
        Color color = new Color(1, 2, 3, 1);
        Color color1 = new Color(1, 2, 4, 1);

        if(color.equals(color1)) {
            System.out.println("Colours are the same.");
        } else {
            System.out.println("Colours are not the same.");
        }

        Polygon pol = new Polygon(pointSet, color);
        System.out.println(pol);
        System.out.println("Program ended.");
    }
}