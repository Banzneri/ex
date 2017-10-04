public class Dog extends Mammal implements SellableItem {

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

    public void sell() {
        System.out.println("Dog has been sold");
    }
}