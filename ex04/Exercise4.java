public class Exercise4 {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            System.out.println();
            if(i == 0) {
                for(int a = 1; a < 10; a++) {
                    System.out.print(a);
                }
            }
            if(i == 1) {
                for(int b = 9; b > 0; b--) {
                    System.out.print(b);
                }
            } 
            if(i == 2) {
                for(int c = 1; c < 11; c++) {
                    if(c % 2 > 0) {
                        System.out.print(c);
                    }
                }
            }
        }
    }
}