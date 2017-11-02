import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class Person extends Observable implements Observer {
    private String name;
    private int age;
    private String gender;
    private Optional<Person> spouse = Optional.empty();
    private int libido;
    private int attractiveness;
    private int alcoholLevel;

    public Person() {

    }

    public Person(String name, int age, String gender,
                    Person spouse, int libido, int attractiveness) {
        setName(name);
        setAge(age);
        setGender(gender);
        setSpouse(spouse);
        setLibido(libido);
        setAttractiveness(attractiveness);
        setAlcoholLevel(0);
    }

    public Person(String name) {
        setName(name);
        setAge(randomWithRange(1, 110));
        setLibido(randomWithRange(0, 100));
        setAttractiveness(randomWithRange(0, 100));
        randomizeGender();
        setAlcoholLevel(0);
    }


    public void update(Observable o, Object arg) {
        Person person = (Person) o;
        LibidoEvent event = (LibidoEvent) arg;
        if(!spouse.isPresent() && !person.getSpouse().isPresent()) {
            if(getLevel(person.getAttractiveness()).equals(getLevel(getAttractiveness())) &&
                event.getStr().equals(getLevel(libido))) {
                setSpouse(person);
                person.setSpouse(this);
                System.out.println(getName() + " married " + person.getName() + "!");
            }   
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0) {
            age = 0;
        } else if(age > 110) {
            age = 110;
        }
        if(age > 50) {
            setLibido(getLibido() - 2);
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if( !(gender.equals("female") || gender.equals("male")) ) {
            this.gender = "other";
        }
        this.gender = gender;
    }

    public Optional<Person> getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = Optional.ofNullable(spouse);
    }

    public int getLibido() {
        return libido;
    }

    public void setLibido(int libido) {
        if(libido < 0) {
            libido = 0;
        } else if(libido > 100) {
            libido = 100;
        }
        setChanged();
        notifyObservers(new LibidoEvent(libido));
        this.libido = libido;
    }

    public String getLevel(int level) {
        if(level >= 20 && level <= 39) {
            return "mild libido";
        } else if(level >= 40 && level <= 59) {
            return "medium libido";
        } else if(level >= 60 && level <= 79) {
            return "hot libido";
        } else if(level >= 80 && level <= 100) {
            return "suicide";
        }
        return "none";
    }

    public int getAttractiveness() {
        return attractiveness;
    }

    public void setAttractiveness(int attractiveness) {
        if(attractiveness < 0) {
            attractiveness = 0;
        } else if(attractiveness > 100) {
            attractiveness = 100;
        }
        this.attractiveness = attractiveness;
    }

    public int getAlcoholLevel() {
        return alcoholLevel;
    }

    public void setAlcoholLevel(int alcoholLevel) {
        if(alcoholLevel < 0) {
            alcoholLevel = 0;
        } else if(alcoholLevel > 100) {
            alcoholLevel = 100;
        }

        if(alcoholLevel >= 5 && alcoholLevel <= 30) {
            setLibido(getLibido() + 5);
        } else if(alcoholLevel <= 100 && alcoholLevel >= 31) {
            setLibido(getLibido() - 5);
        }
        this.alcoholLevel = alcoholLevel;
    }
    
    public int randomWithRange(int min, int max)
    {
       int range = (max - min) + 1;     
       return (int)(Math.random() * range) + min;
    }

    public void randomizeGender() {
        int genderId = randomWithRange(1, 3);

        switch(genderId) {
            case 1: setGender("male");
                    break;
            case 2: setGender("female");
                    break;
            case 3: setGender("other");
        }
    }

    public void drink() {
        setAlcoholLevel(getAlcoholLevel() + 5);
    }

    @Override
    public String toString() {
        String toReturn = "Name: " + name + "\n" +
                            "Age: " + age + "\n" +
                            "Gender: " + gender + "\n" +
                            "Libido: " + libido + "\n" +
                            "Attractiveness: " + attractiveness + "\n" + 
                            "Alcohol level: " + alcoholLevel + "\n" +
                            "Spouse: ";
        if(spouse.isPresent()) {
            toReturn += spouse.get().getName();
        } else {
            toReturn += "no";
        }
        return toReturn;
    }

    class LibidoEvent {
        private int libido;
        private String str;

        public LibidoEvent(int libido) {
            this.libido = libido;
            if(libido >= 20 && libido <= 39) {
                str = "mild libido";
            } else if(libido >= 40 && libido <= 59) {
                str = "medium libido";
            } else if(libido >= 60 && libido <= 80) {
                str = "hot libido";
            } else if(libido >= 80 && libido <= 100) {
                str = "suicide";
            }
        }

        public int getLibido() {
            return libido;
        }

        public String getStr() {
            return str;
        }
    }
}