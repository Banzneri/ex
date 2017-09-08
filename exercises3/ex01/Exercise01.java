import java.util.ArrayList;
import java.util.Arrays;

public class Exercise01 {
    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(new Integer(5));

        int sum = 0;

        for(Integer num: arr) {
            sum += num;
        }

        System.out.println(sum);

        // int muuttuu autoboxingin ansiosta Integeriksi

        // "Autoboxing is the automatic conversion that 
        // the Java compiler makes between the primitive 
        // types and their corresponding object wrapper classes."
    }
}
