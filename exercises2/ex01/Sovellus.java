import java.awt.Color;
import java.util.Scanner;
import java.util.LinkedList;

public class Sovellus {

    public static void main(String[] args) {
        testaaEqualsMetodi();
        testaaColorLuokka();
        tulostaArrayPisteet(kysy5Koordinaattia());
        tulostaLinkedListColor(kysyVareja());
        testaaMystring();
        kaynnistaRoskienKeruu();
    }

    public static Piste[] kysy5Koordinaattia() {
        Piste[] pisteet = new Piste[5];
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ". Anna x-koordinaatti: " );
            int x = scan.nextInt();
            System.out.print((i + 1) + ". Anna y-koordinaatti: ");
            int y = scan.nextInt();
            pisteet[i] = new Piste(x, y);
        }

        return pisteet;
    }

    public static LinkedList<Color> kysyVareja() {
        Scanner scan = new Scanner(System.in);
        LinkedList<Color> coordinates = new LinkedList<>();

        while(true) {
            System.out.print("Anna RGB-koodi (esim: 255 120 33, tyhjä lopettaa): " );
            String[] input = scan.nextLine().split(" ");

            if(input[0].equals("")) {
                break;
            }

            int red = 0;
            int green = 0;
            int blue = 0;

            for(int i = 0; i < input.length; i++) {
                switch(i) {
                    case 0: red = Integer.parseInt(input[i]);
                            break;
                    case 1: green = Integer.parseInt(input[i]);
                            break;
                    case 2: blue = Integer.parseInt(input[i]);
                }
            }

            Color color = new Color(red, green, blue);
            
            coordinates.add(color);
        }
        scan.close();

        return coordinates;
    }

    public static void testaaColorLuokka() {
        Color semiPunainen = new Color(1f, 0f, 0f, 0.5f);
        
        System.out.println(semiPunainen.toString());
        semiPunainen = semiPunainen.brighter();
        System.out.println(semiPunainen.toString() + " brighter");
        semiPunainen = semiPunainen.darker();
        System.out.println(semiPunainen.toString() + " darker");
    }

    public static void testaaEqualsMetodi() {
        Piste origo = new Piste(5, 4);
        Piste origo2 = new Piste(5, 4);
        
        if(origo.equals(origo2)) {
            System.out.println("SAMAT ARVOT");
        } else {
            System.out.println("ERI ARVOT");
        }
    }

    public static void tulostaArrayPisteet(Piste[] pisteet) {
        for(int i = 0; i < pisteet.length; i++) {
            pisteet[i].tulostaArvot();
        }
    }

    public static void tulostaLinkedListColor(LinkedList<Color> list) {
        for(Color color : list) {
            System.out.println(color.toString());
        }
    }

    public static void tulostaPiste(Piste x) {
        System.out.println(x.getX() + " " + x.getY());
    }

    public static void testaaMystring() {
        char[] data = {'m', 'o', 'i', 'k', 'k', 'a'};
        char[] data2 = {'m', 'o', 'i'};
        char[] data3 = {'h', 'e', 'i'};
        char[] data4 = {'m', 'o'};
        MyString myString = new MyString(data);
        MyString myString2 = new MyString(data2);
        MyString myString3 = new MyString(data3);
        MyString myString4 = new MyString(data4);

        myString.print();
        System.out.println("Merkkijonon pituus on " + myString.length()); 
        System.out.println("kolmas kirjain on " + myString.charAt(2));
        myString.reverse();

        if(myString.equals(myString2)) {
            System.out.println("Merkkijonot " + myString.toString() + " ja " + myString2.toString() + " ovat samoja.");
        } else {
            System.out.println("Merkkijonot " + myString.toString() + " ja " + myString2.toString() + " eivät ole samoja.");
        }

        if(myString.startsWith(myString4)) {
            System.out.println("Merkkijono " + myString.toString() + " alkaa annetulla parametrilla " + myString4.toString());
        } else {
            System.out.println("Merkkijono " + myString.toString() + " ei ala annetulla parametrilla " + myString4.toString());
        }

        char c = 'i';

        System.out.println("kirjain " + c + " löytyy sanan " + myString.toString() + " indeksistä " + myString.indexOf(c));
    }

    public static void kaynnistaRoskienKeruu() {
        System.gc();

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Piste {
    private int x;
    private int y;

    public Piste() {
        x = 0;
        y = 0;
    }

    public Piste(int x, int y) {
        this.x = x < 0 ? 0 : x;
        this.y = y < 0 ? 0 : y;
    }

    public void setX(int xPos) {
        if(xPos < 0) {
            x = 0;
        } else {
            x = xPos;
        }
    }

    public void setY(int yPos) {
        if(yPos < 0) {
            y = 0;
        } else {
            y = yPos;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void tulostaArvot() {
        System.out.println(x + " " + y);
    }

    public void kukaMinaOlen() {
        System.out.println(this);
    }

    public boolean equals(Piste x) {
        return x.getX() == this.x && x.getY() == this.y;
    }

    public void finalize() {
        System.out.println("Deleting: " + this);
    }
}

class MyString {
    private char[] myChars;

    public char[] getCharArray() {
        return myChars;
    }

    public MyString(char[] charArray) {
        myChars = charArray;
    }

    public int length() {
        return myChars.length;
    }

    public char charAt(int i) {
        return myChars[i];
    }

    public void print() {
        for(int i = 0; i < myChars.length; i++) {
            System.out.print(myChars[i]);
        }
        System.out.println();
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < length(); i++) {
            str += charAt(i);
        }
        return str;
    }

    public void reverse() {
        for(int i = myChars.length - 1; i >= 0; i--) {
            System.out.print(myChars[i]);
        }
        System.out.println();
    }

    public boolean equals(MyString m) {
        if(m.length() == length()) {
            for(int i = 0; i < length(); i++) {
                if(!(charAt(i) == m.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public boolean startsWith(MyString m) {
        if(length() > m.length()) {
            for(int i = 0; i < m.length(); i++) {
                if(!(charAt(i) == m.charAt(i))) {
                    return false;
                }    
            }
            return true;   
        }
        return false;
    }

    public int indexOf(char c) {
        for(int i = 0; i < length(); i++) {
            if(charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}