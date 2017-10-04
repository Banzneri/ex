public class PlayerCircle extends MyCircle {
    public PlayerCircle(MyDrawingAreaComponent host) {
        setHost(host);
        setX(250);
        setY(250);
        setColor(new java.awt.Color(0, 0, 255));
        setRadius(15);
    }
}