public class Test {
    public static void main(String... args) {
        Person person = new Person();
        Date birthday = new Date(21, 5, 1988);
        Date startDay = new Date(22, 7, 2000);
        double wage = 420;
        Employee pasi =  new Employee("Pasi", birthday, wage, startDay);
        System.out.println(pasi.toString());
    }
}