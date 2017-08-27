import java.util.Scanner;

public class Exercise12 {

    public static void main(String[] args) {
        askInput();
    }

    public static void askInput() {
        Scanner scan = new Scanner(System.in);
        String str = "";

        while(!str.equals("lopeta")) {
            int numberOfWords = 0;
            System.out.print("Anna merkkijono (lopeta): ");
            str = scan.nextLine();
            String trimmed = str.trim();
            numberOfWords = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
            System.out.println("sanoja " + numberOfWords + " kpl");
        }
    }
}