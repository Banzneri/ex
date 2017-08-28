import java.util.Scanner;

public class Exercise5 {
    int number;
    String text;

    public static void main(String[] args) {
        Exercise5 ex = new Exercise5();
        ex.askInput();
        ex.draw();
    }

    public void askInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Anna numero: ");
        number = scan.nextInt();
        System.out.print("Anna merkkijono: ");
        text = scan.next();
        scan.close();
    }

    public void draw() {
        for(int i = 0; i < number; i++) {
            System.out.print(text);
        }
    }
}