public class Programmer extends Person {
    private int wage;

    public Programmer() {
        
    }

    public Programmer(String name) {
        super(name);
    }

    @Override
    public void setAttractiveness(int attractiveness) {
        attractiveness = 0;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public void giveRaise(int a) {
        setWage(getWage() + a);
        setLibido(getLibido() + 5);
    }

    @Override
    public void drink() {
        if(getAlcoholLevel() < 10) {
            setAlcoholLevel(getAlcoholLevel() + 5);
        } else {
            setLibido(0);
            System.out.println("Programmer is passed out");
        }
    }

    @Override
    public String toString() {
        String toReturn = "Name: " + getName() + "\n" +
                            "Age: " + getAge() + "\n" +
                            "Gender: " + getGender() + "\n" +
                            "Libido: " + getLibido() + "\n" +
                            "Attractiveness: " + getAttractiveness() + "\n" + 
                            "Alcohol level: " + getAlcoholLevel() + "\n" + 
                            "Wage: " + getWage() + "\n" + 
                            "Spouse: ";
        if(getSpouse().isPresent()) {
            toReturn += getSpouse().get().getName();
        } else {
            toReturn += "no";
        }
        return toReturn;
    }
}