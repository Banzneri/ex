import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private ArrayList<Person> programmers;
    private ArrayList<Person> nonProgrammers;
    private Thread thread;

    public UI() {
        scanner = new Scanner(System.in);
        programmers = new ArrayList<>();
        nonProgrammers = new ArrayList<>();
        programmers.add(new Programmer("Pasi"));
        programmers.add(new Programmer("Uolevi"));
        nonProgrammers.add(new Person("Jussi"));
        nonProgrammers.add(new Person("Liisa"));
        addAllObservers();
        thread = new Thread(this::updateTime);
    }

    public void addAllObservers() {
        ArrayList<Person> all = new ArrayList<>();
        all.addAll(programmers);
        all.addAll(nonProgrammers);
        for(int i = 0; i < all.size(); i++) {
            for(Person person: all) {
                if(!person.equals(all.get(i))) {
                    all.get(i).addObserver(person);
                }
            }
        }
    }

    public void addObservers(Person person) {
        ArrayList<Person> all = new ArrayList<>();
        all.addAll(programmers);
        all.addAll(nonProgrammers);
        for(Person p : all) {
            p.addObserver(person);
            person.addObserver(p);
        }
    }

    public void updateTime() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateAge();
        }
    }

    public void updateAge() {
        for(Person p: programmers) {
            p.setAge(p.getAge() + 1);
        }
        for(Person p: nonProgrammers) {
            p.setAge(p.getAge() + 1);
        }
    }

    public void getInput() {
        while(true) {
            System.out.print("|H|elp: ");
            String input = scanner.next();
            System.out.println();
            
            switch (input.toLowerCase()) {
                case "help":
                case "h":       showHelp();
                                break;
                case "create programmer":
                case "cp":      createProgrammer();
                                break;
                case "remove programmer":
                case "rp":      removeProgrammer();
                                break;
                case "show programmer":
                case "sp":      showProgrammers();
                                break;
                case "create person":
                case "c":       createPerson();
                                break;
                case "remove person":
                case "r":       removePerson();
                                break;
                case "modify person":
                case "m":       modifyNonProgrammer();
                                break;
                case "modify programmer":
                case "mp":      modifyProgrammer();
                                break;
                case "show person":
                case "s":       showNonProgrammers();
                                break;
                case "drink":
                case "d":       makePersonDrink();
                                break;
                case "start":   System.out.println("Thread started.");
                                thread.start();
                                break;
                case "stop":    System.out.println("Thread stopped.");
                                thread.interrupt();
            
                default:
                    break;
            }
        }
    }

    public void showProgrammers() {
        System.out.println("Showing programmers: ");
        programmers.stream().forEach(e -> System.out.println(e.toString() + "\n"));
    }

    public void showNonProgrammers() {
        System.out.println("Showing persons: ");
        nonProgrammers.stream().forEach(e -> System.out.println(e.toString() + "\n"));
    }

    public void createProgrammer() {
        Programmer programmer = new Programmer();

        System.out.println("Creating a programmer: ");
        askPersonInfo(programmer);
        System.out.print("Wage: ");
        programmer.setWage(scanner.nextInt());
        addObservers(programmer);
        programmers.add(programmer);
    }

    public void createPerson() {
        Person person = new Person();
        askPersonInfo(person);
        addObservers(person);
        nonProgrammers.add(person);
    }

    public void askPersonInfo(Person person) {
        System.out.print("Name: " );
        person.setName(scanner.next());
        System.out.print("Age: " );
        person.setAge(scanner.nextInt());
        System.out.print("Gender: ");
        person.setGender(scanner.next());
        System.out.print("Libido: ");
        person.setLibido(scanner.nextInt());
        System.out.print("Attractiveness: ");
        person.setAttractiveness(scanner.nextInt());
        System.out.print("Does he have a spouse? y/e");
        String ye = scanner.next();
        if(ye.toLowerCase().equals("y")) {
            person.setSpouse(new Person("TheSpouse"));
        }
    }

    public void removeProgrammer() {
        System.out.println("Removing a programmer: ");
        doRemove(programmers);
    }

    public void removePerson() {
        System.out.println("Removing a person: ");
        doRemove(nonProgrammers);
    }

    public void doRemove(ArrayList<Person> list) {
        int index = 1;
        for(Person p : list) {
            System.out.println((index) + ". " + p.getName());
            index++;
        }

        System.out.print("Give index number to remove: ");
        int removeIndex = scanner.nextInt();
        list.remove(removeIndex - 1);
    }

    public int askInt() {
        System.out.print("Give integer: ");
        int num = scanner.nextInt();
        return num;
    }

    public void showHelp() {
        System.out.println("Input:");
        System.out.println("\"c\" / \"create person\" to create a Person");
        System.out.println("\"cp\" / \"create programmer\" to create a Programmer");
        System.out.println("\"r\" / \"remove person\" to remove a Person");
        System.out.println("\"rp\" / \"remove programmer\" to remove a Programmer");
        System.out.println("\"m\" / \"modify person\" to modify a person");
        System.out.println("\"mp\" / \"modify programmer\" to modify a Programmer");
        System.out.println("\"s\" / \"show person\" to show all Persons");
        System.out.println("\"sp\" / \"show programmer\" to show all Programmers");
        System.out.println("\"d\" / \"drink\" to force a Person to drink");
        System.out.println("\"start\" to start a thread which makes all Persons age increase");
        System.out.println("\"stop\" to stop a thread which makes all Persons age increase");
    }

    public void modifyPerson(ArrayList<Person> list) {
        int index = 1;
        for(Person p : list) {
            System.out.println((index) + ". " + p.getName());
            index++;
        }
        System.out.print("Give index number to modify: ");
        int modifyIndex = scanner.nextInt();
        askPersonInfo(list.get(modifyIndex - 1));
        if(list.get(modifyIndex - 1) instanceof Programmer) {
            System.out.print("Wage: ");
            Programmer p = (Programmer) list.get(modifyIndex - 1);
            p.setWage(scanner.nextInt());
        }
    }

    public void modifyProgrammer() {
        System.out.println("Modifying a programmer:");
        modifyPerson(programmers);
    }

    public void modifyNonProgrammer() {
        System.out.println("Modifying a person: ");
        modifyPerson(nonProgrammers);
    }

    public void makePersonDrink() {
        ArrayList<Person> all = new ArrayList<>();
        all.addAll(programmers);
        all.addAll(nonProgrammers);
        int index = 1;
        for(Person p : all) {
            System.out.println((index) + ". " + p.getName());
            index++;
        }
        System.out.print("Give index number to force drink: ");
        int i = scanner.nextInt();
        all.get(i - 1).drink();
        System.out.println("Alcohol level is now " + all.get(i - 1).getAlcoholLevel());
    }
}