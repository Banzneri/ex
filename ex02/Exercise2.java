import java.util.Scanner;

public class Exercise2 {
    int height;

    public static void main(String[] args) {
        Exercise2 ex2 = new Exercise2();
        ex2.askInput();
        ex2.draw();
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
                if(x == y) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}