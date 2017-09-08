class Car {
    String modelName;
    Enum bodyStyle;

    public Car(String modelName, Enum bodyStyle) {
        this.modelName = modelName;
        this.bodyStyle = bodyStyle;
    }

    public String toString() {
        return modelName + ", " + bodyStyle;
    }
}

enum BodyStyle {
    SUV;
}

public class Exercise2 {
    public static void main(String... args) {
        Car merc = new Car("Mercedes GLC", BodyStyle.SUV);
        System.out.println( merc );    
    }
}