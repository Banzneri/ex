public class Test {
    public static void main(String... args) {
        MyColor color = new MyColor();
        color.setB(255); // illegal argument
        color.setR(-1); // illegal argument
    }
}