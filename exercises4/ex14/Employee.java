public class Employee extends Person {
    private double wage;
    private Date startDay;

    public Employee(String name, Date birthday, double wage, Date startDay) {
        super(name, birthday);
        setWage(wage);
        setStartDay(startDay);
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public String toString() {
        return String.format("%s | Wage: %e | StartDay: %s |", super.toString, getWage(), getStartDay());
    }
}