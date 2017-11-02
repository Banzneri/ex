class App {
    public static void main(String [] args) {
        Bird bird = new Bird();
        Airplane airplane = new Airplane();
        flyMe(bird);
        flyMe(airplane);
        flyMe(new Flyable(){    // Anonymous inner class
            @Override
            public void fly(int speed) {
                System.out.println(speed);     
            }
        });
        flyMe(x -> System.out.println(x)); // lambda
        flyMe(System.out::println); // method reference
    }
    public static void flyMe(Flyable f) {
        f.fly(20);
        f.fly(-20);
    }
}

@FunctionalInterface
interface Flyable {
    public void fly(int speed);
}