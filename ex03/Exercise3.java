import java.util.Scanner;

public class Exercise3 {
    double weight;
    double height;

    public static void main(String[] args) {
        Exercise3 ex = new Exercise3();
        ex.askInput();
        ex.calculateBMI();
    }

    public void askInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Anna painosi (kg): ");
        weight = scan.nextDouble();
        System.out.print("Anna pituutesi (m): ");
        height = scan.nextDouble();
        scan.close();
    }

    public void calculateBMI() {
        double bmi = weight / (height * height);
        System.out.print("Painoindeksisi on ");
        System.out.printf("%.2f", bmi);
        System.out.println();
    }
}