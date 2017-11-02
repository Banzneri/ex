import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    // outputs to screen the content of given text-file
	public static void main(String... args) throws IOException {
        Path file = Paths.get(args[0]);
		Files.readAllLines(file).stream()
                                .filter(line -> line.contains("\t"))
								.map(line -> line.replace("\t", "____"))
								.forEach(System.out::println);
    }
}			
