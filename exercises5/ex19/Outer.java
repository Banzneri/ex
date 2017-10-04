public class Outer {
    private int x = 12;

    /*
    public Inner createInner() {
        return new Inner();
    }
    */

    public void doSomeThing() {
        int a = 12;
        final int b = 99;
        int c;
        c = 99;

        class Inner {
            // Can print all of the above variables
            public void print() {
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
            }
        }

        Inner inner = new Inner();
        inner.print();
    }
}