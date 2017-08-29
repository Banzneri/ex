import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Exercise18 {

    public static void main(String[] args) {
        int arraySize = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String line = br.readLine();
            arraySize = line.split(" ").length;

            int[] numbers = new int[arraySize];
            
            for(int i = 0; i < arraySize; i++) {
                numbers[i] = Integer.parseInt(line.split(" ")[i]);
            }

            Scanner scan = new Scanner(System.in);
            System.out.print("Anna arvo: ");
            int value = scan.nextInt();
            scan.close();
    
            for(int i = 0; i < arraySize; i++) {
                if(numbers[i] == value) {
                    System.out.println("Arvo löytyy indeksistä " + i);
                }
            } 

            scan.close();
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}