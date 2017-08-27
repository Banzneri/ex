import java.util.Scanner;
import java.util.Arrays;

public class Exercise9 {
    double canPrice = 0.15;
    double smallBottlePrice = 0.20;
    double bigBottlePrice = 0.40;
    double sum = 0;
    double numberOfReturns = 0;
    String[] correctInputStrings = {"tölkki", "iso", "pieni", "lopeta"};
    
    public static void main(String[] args) {
        Exercise9 ex = new Exercise9();
        ex.askInput();
    }

    public void askInput() {
        String input = "";
        Scanner scan = new Scanner(System.in);

        while(!input.equals("lopeta")) {
            System.out.print("Mitä haluat palauttaa? (tölkki, pieni, iso, lopeta) ");
            input = scan.next();

            if(Arrays.asList(correctInputStrings).contains(input)) {
                numberOfReturns++;
            }

            sum += checkPrice(input);
            System.out.println("Summa: " + Math.round(sum * 100.0) / 100.0);
        }
    }

    public double checkPrice(String returned) {
        if(numberOfReturns % 4 == 0) {
            System.out.println("Kutsu henkilökunta paikalle");
            return 0;
        }

        switch(returned) {
            case "tölkki":  return canPrice;
            case "iso":     return bigBottlePrice;
            case "pieni":   return smallBottlePrice;
            case "lopeta":  return 0;
        }

        System.out.println("Väärä komento!");
        return 0;
    }
}