public class MyColor {
    private int r;
    private int g;
    private int b;

    public int getR() {
        return r;
    }

    public void setR(int r) throws IllegalArgumentException {
        if(r < 0 || r > 255) {
            throw new IllegalArgumentException();
        } else {
            this.r = r;
        }
    }

    public int getG() {
        return g;
    }

    public void setG(int g) throws IllegalArgumentException {
        if(g < 0 || g > 255) {
            throw new IllegalArgumentException();
        } else {
            this.g = g;
        }
    }

    public int getB() {
        return b;
    }

    public void setB(int b) throws IllegalArgumentException {
        if(b < 0 || b > 255) {
            throw new IllegalArgumentException();
        } else {
            this.b = b;
        }
    }
}