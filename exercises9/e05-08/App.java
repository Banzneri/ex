import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX HelloWorld!");
        stage.initStyle(StageStyle.DECORATED);
        // stage.setWidth(640);
        // stage.setHeight(480);
        stage.centerOnScreen();
        Button button1 = new Button("Hello");
        Button button2 = new Button("World");
        Group group = new Group(button1, button2);
        Scene scene = new Scene(group, 640, 480);
        stage.setScene(scene);
        stage.show();
        button2.setTranslateX(button1.getTranslateX() + button2.getWidth());
    }

    @Override
    public void init() {
        System.out.println("init");
    }

    public App() {
        System.out.println("Application");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    public static void main(String... args) {
        launch(args);
    }
    

}