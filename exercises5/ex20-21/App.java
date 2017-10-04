class App {
    public static void main(String [] args) {
         class Television implements SellableItem {
              public void sell() {
                  System.out.println("TV sold");
              }
         }

         // ex20 - anonymous inner class object
         method(new SellableItem() {
             public void sell() {
                 System.out.println("TV sold");
             }
         });

         // ex21 - lambda
         method(() -> System.out.println("TV sold"));
    }
    public static void method(SellableItem a) {
         a.sell();
    }
}