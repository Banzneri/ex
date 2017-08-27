import java.util.Scanner;
import java.util.Arrays;

public class Exercise6 {
    
    public static void main(String[] args) {
        int number;
        String text;

        Scanner scan = new Scanner(System.in);
        System.out.print("Anna numero: ");
        number = scan.nextInt();
        System.out.print("Anna merkkijono: ");
        text = scan.next();
        scan.close();

        String toReturn = "";
        
        for(int i = 0; i < number; i++) {
            toReturn += text;
        }

        System.out.println(draw(toReturn));
    }

    public static String draw(String str) {
        return str;
    }
}