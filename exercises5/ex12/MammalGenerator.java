public abstract class MammalGenerator {

    public abstract void start(Mammal mammal);

    public void launch(String[] args) {
        if(args[0].equals("dog")) {
            start(new Dog("spot"));
        } else {
            start(new Human("Pasi"));
        }
    }
}