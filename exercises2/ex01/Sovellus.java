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

public class Sovellus {

    public static void main(String[] args) {
        Piste origo = new Piste(5, 4);
        Piste origo2 = new Piste(5, 4);

        if(origo.equals(origo2)) {
            System.out.println("SAMAT ARVOT");
        } else {
            System.out.println("ERI ARVOT");
        }
        
        origo.tulostaArvot();
        tulostaPiste(origo);
        kaynnistaRoskienKeruu();
    }

    public static void kaynnistaRoskienKeruu() {
        System.gc();

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tulostaPiste(Piste x) {
        System.out.println(x.getX() + " " + x.getY());
    }
}