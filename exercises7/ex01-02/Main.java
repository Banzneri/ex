public class Main {
    public static void main(String... args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
        
            System.out.println(Integer.toString(division(a, b)));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    // Excercise 2
    public static int division(int a, int b) throws CannotBeTenException {
        if(a / b == 10) {
            throw new CannotBeTenException();
        } else {
            return a / b;
        }
    }
}

//  Jos luokka periytyy RuntimeExceptionista, sitä ei tarvitse laittaa
//  try/catchiin.
class CannotBeTenException extends RuntimeException {

}