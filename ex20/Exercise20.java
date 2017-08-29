import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Exercise20 {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            Scanner scan = new Scanner(System.in);

            System.out.print("Anna arvo: ");
            int value = scan.nextInt();

            String[] input = br.readLine().split(", ");
            int[] numbers = new int[input.length];

            for(int i = 0; i < input.length; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }

            scan.close();
            br.close();

            int left = 0;
            int right = numbers.length - 1;
            int middle = 0;
            long startTime = System.nanoTime();

            while(left <= right) {
                middle = (left + right) / 2;
                if(numbers[middle] == value) {
                    long finishedTime = System.nanoTime();
                    double elapsedTime = (finishedTime - startTime) / 1e6;
                    System.out.println("Arvo löytyy indeksistä " + middle + 
                    "\n Aikaa kului " + elapsedTime + " millisekuntia");
                    break;
                } else if(value < numbers[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}