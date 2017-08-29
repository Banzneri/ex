import java.util.Arrays;
import java.util.Scanner;

public class Exercise17 {

    public static void main(String[] args) {
        askInput();
    }

    public static void askInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Anna kokonaislukuja: ");
        String[] input = scan.nextLine().split(" ");
        System.out.print("Anna arvo: ");
        int value = scan.nextInt();
        int[] numbers = new int[input.length];

        for(int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == value) {
                System.out.println("Arvon indeksi on " + i);
            }
        }
    }
}