import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    // outputs to screen the content of given text-file
	public static void main(String... args) throws IOException {
        try {
            Stream<Path> paths = Files.walk(Paths.get("./")); 
            List<Path> files = paths.filter((e) -> e.toString()
                                    .contains(".java"))
                                    .collect(Collectors.toList());
            for(Path file : files) {
                Files.readAllLines(file)
                        .stream()
                        .map(e -> e.replace("\t", "____"))
                        .forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}			
