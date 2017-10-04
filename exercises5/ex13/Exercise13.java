import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise13 extends Application {

    public static void main(String... args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Mun ikkuna!");
        Button btn = new Button();
        btn.setText("Say hello world");

        btn.setOnAction((e) -> System.out.println("Hello!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }
}