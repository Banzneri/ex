public class Human extends Mammal {

    public Human(String name) {
        super(name);
    }

    public void createArt() {
        System.out.println("creating art");
    }

    @Override
    public void makeSound() {
        System.out.println("Making a human sound!");
    }
}