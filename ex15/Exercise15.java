import java.util.Scanner;
import java.util.Arrays;

public class Exercise15 {

    public static void main(String[] args) {

        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.",
                              "--.", "....", "..", ".---", "-.-", ".-..",
                              "--", "-.", "---", ".--.", "--.-", ".-.",
                              "...", "-", "..-", "...-", ".--", "-..-",
                              "-.--", "--.."};

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
                             "j", "k", "l", "m", "n", "o", "p", "q", "r",
                             "s", "t", "u", "v", "w", "x", "y", "z"};

        Scanner scan = new Scanner(System.in);
        System.out.print("Give morse code (- for dash, . for dot): ");
        String morse = scan.nextLine();
        scan.close();
        String[] input = morse.split(" ");
        String output = "";

        for(int i = 0; i < input.length; i++) {
            for(int a = 0; a < morseCode.length; a++) {
                if(input[i].equals(morseCode[a])) {
                    output += alphabet[a] + " ";
                }
            }
        }

        System.out.println(output);
        
        

    }
}