public class Test {
    public static void main(String... args) {
        Outer outer = new Outer();
        outer.createInner().print();

        Outer.Inner inner = outer.new Inner();
        inner.print();
    }
}