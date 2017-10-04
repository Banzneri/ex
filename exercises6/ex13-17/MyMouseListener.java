import java.awt.*;
import java.awt.event.*;


class MyMouseListener extends MouseAdapter {
    private MyDrawingAreaComponent host;

    public MyMouseListener(MyDrawingAreaComponent host) {
        this.host = host;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        host.setXPos(e.getX());
        host.setYPos(e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        host.setXPos(e.getX());
        host.setYPos(e.getY());
    }
}