public class Test {
    public static void main(String... args) {
        Dog spot = new Dog("Spot");
        Human pasi = new Human("Pasi");
        Bird birb = new Bird("birb");

        spot.giveBirthToLivingChild();

        System.out.println(spot.getName());
        System.out.println(pasi.getName());
        System.out.println(birb.getName());

        pasi.createArt();
        spot.sniffButt();
        birb.fly();

        pasi.makeSound();
        spot.makeSound();

        method1(pasi);
        method2(spot);
        method3(pasi);
        method4("object");

        method2(spot);


        if(pasi.eats(spot)) {
            System.out.println("Success! Human ate dog.");
            System.out.println(spot.isAlive()); // returns false
        }


        if(birb.eats(spot)) {
            System.out.println("Success! Bird ate dog.");
            System.out.println(spot.isAlive()); // returns false
        }


        if(spot.eats(pasi)) {
            System.out.println("Success! Dog ate human.");
            System.out.println(spot.isAlive()); // returns false
        }
    }


    public static void method1(Animal a) {

    }

    public static void method2(Mammal a) {
        a.giveBirthToLivingChild();
    }

    public static void method3(Human a) {
    
    }

    public static void method4(Object a) {
    
    }
}