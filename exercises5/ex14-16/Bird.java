public class Bird extends Animal implements SellableItem {

    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println("flying");
    }

    public void sell() {
        System.out.println("Bird has been sold");
    }
}