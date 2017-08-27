import java.util.Scanner;

public class Exercise13 {
    
    public static void main(String[] args) {
        askInput();
    }

    public static void askInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Anna numero: ");
        int num = scan.nextInt();
        draw(num);
    }

    public static void draw(int num) {
        for(int y = 0; y < num; y++) {
            System.out.println();
            for(int x = 0; x < num; x++) {
                if(y == x || x + y == num - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
}