public class Dog extends Mammal {

    public Dog(String name) {
        super(name);
    }

    public void sniffButt() {
        System.out.println("sniffing butt");
    }

    @Override
    public void makeSound() {
        System.out.println("Barking!");
    }
}