public class Test {
    SoftDrink drink;
    Dog dog;
    Bird bird;
    Store store;
    
    public Test() {
        drink = new SoftDrink();
        dog = new Dog("Spot");
        bird = new Bird("Bird");
        store = new Store("kauppa");
    }

    public void testSellableItems() {
        drink.sell();
        dog.sell();
        bird.sell();
    }

    public void testStore() {
        store.addSellableItem(dog);
        store.addSellableItem(bird);
        store.addSellableItem(drink);

        store.getSellableItem(0);

        store.removeSellableItem(bird);

        store.sellAllItems();
    }
}