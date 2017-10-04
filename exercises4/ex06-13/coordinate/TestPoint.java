package coordinate;

import coordinate.Point;

// TestPoint kuuluu samaan pakettiin, jonka vuoksi se näkee
// Pointin attribuutit, jotka ovat protected
class TestPoint {
    public static void main(String... args) {
        Point a = new Point();
        a.x = 4;
        a.y = 10;
        System.out.println(a.x + " " + a.y);
    }
}