public class Person {
    private String name;
    private Date birthday;

    public Person() {

    }

    public Person(String name, Date birthday) {
        setName(name);
        setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return "| Name: " + name + " | Birthday: " + birthday.toString() + " | ";
    } 
}