public abstract class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
    }

    public void giveBirthToLivingChild() {
        System.out.println("Giving birth to living child");
    }

    public abstract void makeSound();
}