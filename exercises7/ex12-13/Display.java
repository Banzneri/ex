import java.util.Optional;

public class Display {
    private int resolutionX;
    private int resolutionY;
    private Optional<Stand> stand = Optional.empty();

    public int getResolutionX() {
        return resolutionX;
    }

    public void setResolutionX(int resolutionX) {
        this.resolutionX = resolutionX;
    } 

    public int getResolutionY() {
        return resolutionY;
    }

    public void setResolutionY(int resolutionY) {
        this.resolutionY = resolutionY;
    }

    public Optional<Stand> getStand() {
        return stand;
    }

    public void setStand(Optional<Stand> stand) {
        this.stand = stand;
    }
}