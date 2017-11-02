import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class App {
    
    public static void main(String... args) {

        for(String string : args) {
            Path path = Paths.get(string);
            Thread thread = new Thread(() -> handleTxtFile(path));
            thread.start();
        }
        System.out.println("Sorted the files.");
    }

    public static void handleTxtFile(Path filePath) {
        try {
            ArrayList<Person> personList = new ArrayList<>();

            // splits the strings and creates Persons and Spouses
            for(String string : Files.readAllLines(filePath)) {
                String[] arr = string.split("->"); // splits into Persons and spouses
                Person person = new Person(arr[0].split("::")[1], arr[0].split("::")[0]);
                personList.add(person);

                if(arr.length > 1) { // checks if the Person has a spouse
                    Spouse spouse = new Spouse(arr[1].split("::")[1], arr[1].split("::")[0]);
                    person.setSpouse(Optional.of(spouse));
                }
            }

            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
            ArrayList<Person> personsWithSpouse = new ArrayList<>();
            personList.forEach(p -> p.getSpouse().ifPresent(e -> personsWithSpouse.add(p)));
            personList.removeAll(personsWithSpouse);
            Collections.sort(personList);
            Collections.sort(personsWithSpouse);
            personList.addAll(personsWithSpouse);

            for(Person person : personList) {
                Files.write(filePath, (person.toString()+"\n").getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}