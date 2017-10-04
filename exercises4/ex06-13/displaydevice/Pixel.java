package displaydevice;
import coordinate.Point;

public class Pixel extends Point {
    private String color;

    public Pixel() {
        System.out.println("Pixel created (default constructor)");
    }

    // 9.   x ja y on syötettävä super() constructorin kautta, koska
    //      Point-luokan attribuutit ovat private
    public Pixel(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(color);
    }
}