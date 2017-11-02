import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String... args) {
        Computer computer = new Computer();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Computer brand? ");
        String brand = scanner.next();
        System.out.print("Has display? Y/N ");
        boolean hasDisplay = scanner.next().equals("y") ? true : false;
        
        if(hasDisplay) {
            Display display = new Display();

            System.out.print("resolution x: ");
            int resoX = scanner.nextInt();
            System.out.print("resolution y: ");
            int resoY = scanner.nextInt();
            System.out.print("Does it have a stand? Y/N ");
            boolean hasStand = scanner.next().equals("y") ? true : false;

            if(hasStand) {
                System.out.print("Height of the stand: ");
                int height = scanner.nextInt();
                display.setStand(Optional.of(new Stand(height)));
            }

            display.setResolutionX(resoX);
            display.setResolutionY(resoY);
            computer.setDisplay(Optional.of(display));
        }
        scanner.close();

        Optional<Display> d = computer.getDisplay();
        d.ifPresent(e -> {
            Optional<Stand> stand = e.getStand();
            stand.ifPresent(s -> System.out.println("Height of stand: " + s.toString()));
        });
    }
}