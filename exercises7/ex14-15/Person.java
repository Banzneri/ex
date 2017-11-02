import java.util.Optional;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private Optional<Spouse> spouse;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        spouse = Optional.empty();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Optional<Spouse> getSpouse() {
        return spouse;
    }

    public void setSpouse(Optional<Spouse> spouse) {
        this.spouse = spouse;
    }
    
    @Override
    public String toString() {
        if(spouse.isPresent()) {
            return getLastName() + "::" + getFirstName() + "->" + spouse.get().draw();
        }
        return getLastName() + "::" + getFirstName() + "->";
    }

    @Override
    public int compareTo(Person person) {
        return getLastName().compareTo(person.getLastName());
    }
}