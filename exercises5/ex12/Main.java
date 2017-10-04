public class Main extends MammalGenerator {
    public void start(Mammal mammal) {
        mammal.makeSound();
    }
    
    public static void main(String... args) {
        new Main().launch(args);
    }
}