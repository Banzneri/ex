public class EnemyCircle extends MyCircle {
    private long velocityChangeStartTime;
    private long velocityChangeCounter;
    private int velocityChangeInterval;

    public EnemyCircle(MyDrawingAreaComponent host) {
        setHost(host);
        setX(MyUtils.getRandom(0, 498));
        setY(MyUtils.getRandom(0, 498));
        setColor(new java.awt.Color(MyUtils.getRandom(0, 255),
                                    MyUtils.getRandom(0, 255),
                                    MyUtils.getRandom(0, 255)));
        setRadius(MyUtils.getRandom(10, 30));
        setVelocityX(MyUtils.getRandom(-3, 3));
        setVelocityY(MyUtils.getRandom(-3, 3));

        velocityChangeCounter = 0;
        velocityChangeInterval = MyUtils.getRandom(1, 3);
        velocityChangeStartTime = System.nanoTime();
    }

    public void move() {
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());

        velocityChangeCounter = System.nanoTime() - velocityChangeStartTime;
        if((double) velocityChangeCounter / 1000000000.0 > velocityChangeInterval) {
            changeVelocity();
            velocityChangeCounter = 0;
            velocityChangeInterval = MyUtils.getRandom(1, 5);
            velocityChangeStartTime = System.nanoTime();
        }
        
    }

    public void changeVelocity() {
        setVelocityX(MyUtils.getRandom(-5, 5));
        setVelocityY(MyUtils.getRandom(-5, 5));
    }
}