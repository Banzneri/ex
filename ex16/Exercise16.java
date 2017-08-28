public class Exercise16 {

    public static void main(String[] args) {
        for(int i = 1; i < 11; i++) {
            System.out.println();
            for(int a = 1; a < 11; a++) {
                int product = i * a;
                if(i * a < 10) {
                    System.out.print("00" + product + " ");
                } else if(i * a < 100) {
                    System.out.print("0" + product + " ");
                } else {
                    System.out.print(product);
                }
            }
        }
        System.out.println();
    }
}