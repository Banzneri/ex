public class Exercise3 {
    public static void main(String[] args) {
        for(int y = 1; y < 11; y++) {
            System.out.println();
            for(int x = 1; x < 11; x++) {
                System.out.format("%03d ", y * x);
            }
        }
    }
}