import java.util.Scanner;

public class Exercise1 {
    int height;

    public static void main(String[] args) {
        Exercise1 ex = new Exercise1();

        ex.askInput();
        ex.draw();
    }
    
    public void askInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Anna numero: ");
        height = scan.nextInt();
        scan.close();
    }

    public void draw() {
        for(int y = 0; y < height; y++) {
            System.out.println();
            for(int x = 0; x < height; x++) {
                if(x == height - 1 || y == height - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
        }
    }
} 