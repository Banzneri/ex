import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

    public static void main(String... args) {
        List<String> list = Arrays.asList("1", "3", "5", "4");
        Stream<String> stream = list.stream();
        IntStream intStream = stream.mapToInt(new Listener());
        intStream.forEach(new Printable());
    }
}

class Listener implements ToIntFunction<String> {
    public int applyAsInt(String value) {
        return Integer.parseInt(value);
    }
}

class Printable implements IntConsumer {
    public void accept(int value) {
        System.out.println(Integer.toString(value));
    }
}