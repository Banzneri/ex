public class Spouse extends Person {
    public Spouse(String firstName, String lastName){
        super(firstName, lastName);
    }

    public String draw() {
        return getLastName() + "::" + getFirstName();
    }
}