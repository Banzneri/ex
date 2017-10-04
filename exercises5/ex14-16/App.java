class App {
    public static void main(String... args) {
        Test test = new Test();
        test.testSellableItems();
        test.testStore();
    }

    // Metodiin voidaan antaa parametreiksi kaikki oliot,
    // jotka toteuttavat SellableItem-rajapinnan
    public static void method(SellableItem a) {
        
    }
}