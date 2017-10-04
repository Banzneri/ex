import coordinate.Point;
import displaydevice.Pixel;

// Test-luokka ei näe Pixel-luokan attribuutteja, koska se ei
// kuulu samaan pakettiin eikä periydy pixelistä.
//
// pixel.print() toimii, koska sen käyttämät Point-luokan attribuutit
// ovat protected, ja Pixel periytyy Pointista
public class Test {
    public static void main(String... args) {
        Pixel pixel = new Pixel();
        pixel.x = 10;
        pixel.y = 5;
        pixel.color = "blue";

        pixel.print();
    }
}