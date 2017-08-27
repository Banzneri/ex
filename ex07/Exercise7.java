import java.util.Scanner;

public class Exercise7 {
    
    public static void main(String[] args) {
        System.out.print(draw());
    }

    public static int readInteger() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Anna numero: ");
        int number = scan.nextInt();
        return number;
    }

    public static String draw() {
        int num = readInteger();
        String toReturn = "";

        for(int i = 0; i < num; i++) {
            toReturn += "\n";
            for(int a = 0; a < num; a++) {
                if(a == 0 || a == num - 1 || i == num / 2) {
                    toReturn += "X";
                } else {
                    toReturn += " ";
                }
            } 
        }

        return toReturn;
    }
}