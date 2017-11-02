public class Test {

    public static void main(String... args) {
        MyLinkedList<TestObject> linkedList = new MyLinkedList<>();
        MyArrayList<TestObject> arrayList = new MyArrayList<>();
        calculateListsAdd(arrayList, linkedList);
        calculateListsGet(arrayList, linkedList);
        calculateListsRemove(arrayList, linkedList);
        System.out.println(linkedList.get(5).id);
    }

    public static void populateList(MyList<TestObject> list) {
        for(int i = 0; i < 10000000; i++) {
            list.add(new TestObject("obj" + 1, i));
        }
    } 

    public static void listElements(MyList<TestObject> list) {
        System.out.println("Size of list: " + list.size());
        System.out.println("Elements of the list (index):");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.get(i).getName() + " ("+i+")" );
        }
    }

    public static void calculateListsGet(MyList<TestObject> arrayList, MyList<TestObject> linkedList) {
        long startTimeArray = System.nanoTime();
        arrayList.get(7000000);
        long elapsedTimeArray = System.nanoTime() - startTimeArray;
        long startTimeLinked = System.nanoTime();
        linkedList.get(7000000);
        long elapsedTimeLinked = System.nanoTime() - startTimeLinked;
        System.out.println("Get:");
        System.out.println("\tArray: " + elapsedTimeArray);
        System.out.println("\tLinked: " + elapsedTimeLinked);
    }

    public static void calculateListsRemove(MyList<TestObject> arrayList, MyList<TestObject> linkedList) {
        long startTimeArray = System.nanoTime();
        arrayList.remove(90000);
        long elapsedTimeArray = System.nanoTime() - startTimeArray;
        long startTimeLinked = System.nanoTime();
        linkedList.remove(90000);
        long elapsedTimeLinked = System.nanoTime() - startTimeLinked;
        System.out.println("Remove:");
        System.out.println("\tArray: " + elapsedTimeArray);
        System.out.println("\tLinked: " + elapsedTimeLinked);
    }

    public static void calculateListsAdd(MyList<TestObject> arrayList, MyList<TestObject> linkedList) {
        long startTimeArray = System.nanoTime();
        populateList(arrayList);
        long elapsedTimeArray = System.nanoTime() - startTimeArray;
        long startTimeLinked = System.nanoTime();
        populateList(linkedList);
        long elapsedTimeLinked = System.nanoTime() - startTimeLinked;
        System.out.println("Add");
        System.out.println("\tarray: " + elapsedTimeArray);
        System.out.println("\tlinked: " + elapsedTimeLinked);
    }
    
}

class TestObject {
    public String name;
    public int id;

    public TestObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}