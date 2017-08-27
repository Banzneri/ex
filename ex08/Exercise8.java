import java.util.Scanner;

public class Exercise8 {
    
    public static void main(String[] args) {
        draw();
    }

    public static int readInteger() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Anna numero: ");
        int number = scan.nextInt();
        return number;
    }

    public static void draw() {
        int num = readInteger();
        String[][] toReturn = new String[num][num];

        for(int y = 0; y < num; y++) {
            
            for(int x = 0; x < num; x++) {
                if(x == 0 || x == num - 1 || y == num / 2) {
                    toReturn[y][x] = "X";
                } else {
                    toReturn[y][x] = " ";
                }
            } 
        }

        for(int y = 0; y < num; y++) {
            System.out.println();
            for(int x = 0; x < num; x++) {
                System.out.print(toReturn[y][x]);
            } 
        }
    }
}