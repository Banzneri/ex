import coordinate.Point;
import displaydevice.Pixel;

// Koska muuttujat ovat private, Test-luokka ei näe niitä
// pixel.print() ei toimi koska Point-luokan x ja y ovat myös
// private, joten Pixel ei näe niitä
public class Test {
    public static void main(String... args) {
        Pixel pixel = new Pixel();
        // pixel.x = 10;
        // pixel.y = 5;
        // pixel.color = "blue";

        pixel.print();
    }
}