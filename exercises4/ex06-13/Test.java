import coordinate.Point;
import displaydevice.Pixel;

//      VASTAUKSET TEHTÄVIEN KYSYMYKSIIN
//      --------------------------------
//
// 6:   Pixel-luokka ei pysty suoraan pääsemään käsiksi Point-luokan
//      attribuutteihin, jotka ovat nyt privateja, vaikka se perityykin 
//      Point-luokasta. Se pystyy kuitenkin kutsumaan super.print(), jolloin
//      Point-luokka tulostaa itse omat attribuuttinsa.
//
// 7:   Kun pixel luodaan, kutsuu se yläluokkansa constructoria, joten tulosteena
//      tulee ensin 'Point created', jonka jälkeen 'Pixel created'.
//
// 9:   Vastaus löytyy Pixel-luokasta
//
// 10:  Pixel-luokan default constructor yrittää kutsua yläluokkansa Pointin default
//      constructoria, eikä onnistu koska se on nyt kommentoitu pois.
//
// 11:  Kun Pixel-luokan print()-metodiin on lisätty @Override, ja nimi muutettu printTypo(),
//      ohjelma ei käänny, koska se ei löydä samannimistä metodia yläluokasta
//
// 12:  @Override toString()-metodissa toimii, koska kaikki luokat periytyvät Object-luokasta,
//      jolla on toString()-niminen metodi.
//      Kun System.out.println() saa parametrikseen olion, se tulostaa sen olion toString()-metodin
//      palauttaman merkkijonon, ja Point-luokan kohdalla toString() palauttaa x ja y attribuuttien
//      arvot.
//
// 13:  method1() ottaa vastaan point- ja pixel-olion,
//      method2() ottaa vastaan ainoastaan pixel-olion,
//      method3() ottaa vastaan minkä olion tahansa.
//
public class Test {
    public static void main(String... args) {
        Pixel pixel = new Pixel();
        Point point = new Point();
        Pixel pixel1 = new Pixel(4, 4, "red");
        Point point1 = new Point(4, 4);
        pixel.print();
        System.out.println(point);

        method1(pixel);
        method2(pixel);
        method3("olio");
    }

    public static void method1(Point point) {

    }

    public static void method2(Pixel pixel) {
        
    }

    public static void method3(Object object) {
        
    }
}