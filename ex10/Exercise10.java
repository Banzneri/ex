import java.util.Arrays;

public class Exercise10 {

    public static void main(String[] args) {
        int[] array = {0, 3, 45};
        loytyykoTaulukosta(array, 45);
    }

    public static int loytyykoTaulukosta(int[] taulukko, int arvo) {
        for(int i = 0; i < taulukko.length; i++) {
            if(taulukko[i] == arvo) {
                System.out.println(i);
                return i;
            }
        }
        
        return 0;
    }
}