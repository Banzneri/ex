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
        Polygon pol = new Polygon(pointSet, color);
        System.out.println(pol);
        System.out.println("Program ended.");
    }
}