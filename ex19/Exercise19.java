import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Exercise19 {

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

            long startTime = System.nanoTime();

            for(int i = 0; i < numbers.length; i++) {
                if(numbers[i] == value) {
                    long finishedTime = System.nanoTime();
                    long timeDifference = finishedTime - startTime;
                    double elapsedTime = timeDifference / 1e6;
                    System.out.println("Arvo löytyy indeksistä " + i + 
                                       "\n Aikaa kului " + elapsedTime + " millisekuntia");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}