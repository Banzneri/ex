import java.util.Arrays;

public class Exercise11 {

    public static void main(String[] args) {
        jokaToinen(new int[] {4, 2, 12, 3, 8, 9, 10});
    }

    public static int[] jokaToinen(int[] taulukko) {
        int size = taulukko.length;
        int[] palautettavaTaulukko = size % 2 == 0 ? new int[size / 2] : new int[size / 2 + 1];
        int count = 0;

        for(int i = 0; i < size; i++) {
            if(i % 2 == 0) {
                count++;
                palautettavaTaulukko[count - 1] = taulukko[i];
            }
        }

        System.out.println(Arrays.toString(palautettavaTaulukko));
        return palautettavaTaulukko;
    }
}