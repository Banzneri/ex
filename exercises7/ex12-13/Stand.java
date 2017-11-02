public class Stand {
    private int height;

    public Stand(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return Integer.toString(height);
    }
}