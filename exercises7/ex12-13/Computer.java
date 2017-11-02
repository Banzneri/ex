import java.util.Optional;

public class Computer {
    private String brand;
    private Optional<Display> display = Optional.empty();

    public Optional<Display> getDisplay() {
        return display;
    }

    public void setDisplay(Optional<Display> display) {
        this.display = display;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}