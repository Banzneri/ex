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
        IntStream intStream = stream.mapToInt((e) -> Integer.parseInt(e));
        intStream.forEach((e) -> System.out.println(e));
    }
}