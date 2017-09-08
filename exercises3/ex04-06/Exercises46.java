class Line {
    private Point startingPoint;
    private Point endingPoint;

    public Line(int firstX, int firstY, int secondX, int secondY) {
        this.startingPoint = new Point(firstX, firstY);
        this.endingPoint = new Point(secondX, secondY);
    }

    public String toString() {
        return startingPoint.toString() + ", " + endingPoint.toString(); 
    }

    // Exercise 5
    public boolean equals(Line line) {
        return toString().equals(line.toString());
    }

    void setStartingPoint(Point point) {
        this.startingPoint = new Point(point.getX(), point.getY());
    }

    void setEndingPoint(Point point) {
        this.endingPoint = new Point(point.getX(), point.getY());
    }

    void setStartingPoint(int x, int y) {
        this.startingPoint = new Point(x, y);
    }

    void setEndingPoint(int x, int y) {
        this.startingPoint = new Point(x, y);
    }

    Point getStartingPoint() {
        return startingPoint;
    }

    Point getEndingPoint() {
        return endingPoint;
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "[x = " + x + ", y = " + y + "]";
    }
}

public class Exercises46 {
    public static void main(String[] args) {
        Line line = new Line(5, 5, 10, 10);
        System.out.println(line);
        //testEx5();
        testEx6();
    }

    // Exercise 5
    public static void testEx5() {
        Line line1 = new Line(5, 5, 10, 10);
        Line line2 = new Line(5, 5, 10, 10);

        if (line1.equals(line2)) {
            System.out.println("Lines are the same.");
        } else {
            System.out.println("Lines are not the same.");
        }
    }

    // Exercise 6
    public static void testEx6() {
        // Changes in 'line1' should only happen through its own setters.
        // a.setX() looks like its changing only 'a', but
        // the changes propagate to 'line1' because 'a' stays in memory.
        // I fixed it by tweaking the Line setters so they create new 
        // objects using data from 'a', instead of using 'a' as the new value
        Line line1 = new Line(5, 5, 10, 10);
        Point a = new Point(100, 50);
        line1.setStartingPoint(a);
        a.setX(1);
        System.out.println(line1);
    }
}