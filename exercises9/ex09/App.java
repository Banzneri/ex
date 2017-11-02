import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class App extends Application {
    private Label topLabel;
    private Button bottomButton;
    private Slider rightSlider;
    private BorderPane pane;
    private GridPane gridPane;
    private TreeSet<Integer> userChosenNumbers = new TreeSet<>();
    private TreeSet<Integer> randomNumbers = new TreeSet<>();
    private Thread thread = new Thread(this::count);
    private int years = 0;

    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX HelloWorld!");
        stage.initStyle(StageStyle.DECORATED);
        gridPane = generateGridPane();
        initBorderPane();
        randomNumbers = createRandomNumbers();
        Scene scene = new Scene(pane, 640, 640);
        stage.setScene(scene);
        stage.show();   
    }

    public static void main(String... args) {
        launch(args);
    }
    
    public void initBorderPane() {
        bottomButton = new Button("I Feel Lucky");
        topLabel = new Label("Choose numbers");
        rightSlider = createSlider();
        pane = new BorderPane();
        BorderPane topPane = new BorderPane();

        bottomButton.setOnAction(this::doOnAction);
        bottomButton.setDisable(true);
        topPane.setTop(createMenuBar());
        topPane.setBottom(topLabel);        
        pane.setTop(topPane);
        pane.setBottom(bottomButton);
        pane.setRight(rightSlider);
        BorderPane.setAlignment(topLabel, Pos.TOP_CENTER);
        BorderPane.setMargin(topLabel, new Insets(10, 0, 0, 0));
        BorderPane.setAlignment(bottomButton, Pos.BOTTOM_CENTER);
        BorderPane.setMargin(bottomButton, new Insets(0, 0, 10, 0));
        pane.setCenter(gridPane);
        BorderPane.setMargin(gridPane, new Insets(10, 10, 10, 10));
    }

    public Slider createSlider() {
        Slider s = new Slider();
        s.setOrientation(Orientation.VERTICAL);
        s.setMin(1);
        s.setMax(10);
        s.setValue(1);
        s.setMajorTickUnit(1);
        s.setShowTickMarks(true);
        s.setShowTickLabels(true);
        s.setSnapToTicks(true);
        s.setMinorTickCount(0);
        return s;
    }

    public TreeSet<Integer> createRandomNumbers() {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < 7; i++) {
            int random = (int)((Math.random() * 40) + 1);
            while(set.contains(random)) {
                random = (int)(Math.random() * 40) + 1;
            }
            set.add(random);
        }
        return set;
    }

    public int getSliderValue() {
        return (int)rightSlider.getValue();
    }

    public GridPane generateGridPane() {
        int columns = 7;
        int rows = 6;
        GridPane gridPane = new GridPane();
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(100 / columns);
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(100 / rows);

        for(int i = 0; i < columns; i++) {
            gridPane.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            gridPane.getRowConstraints().add(row);
        }
        
        int i = 1;
        main: for(int y = 0; y < 6; y++) {
            for(int x = 0; x < 7; x++) {
                ToggleButton button = new ToggleButton(Integer.toString(i++));
                GridPane.setFillHeight(button, true);
                GridPane.setFillWidth(button, true);
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                gridPane.add(button, x, y);
                button.setOnAction(this::chooseNumber);
                button.setShape(new Circle(50));
                button.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 40% , white, yellow);");

                GridPane.setMargin(button, new Insets(5, 5, 5, 5));
    
                if(i > 40)
                    break main;
            }
        }
        return gridPane;
    }

    public MenuBar createMenuBar() {
        MenuBar bar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuAbout = new Menu("About");
        Menu menuSkill = new Menu("Skill level");

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem five = new RadioMenuItem("5");
        RadioMenuItem six = new RadioMenuItem("6");
        RadioMenuItem seven = new RadioMenuItem("7");
        RadioMenuItem musicItem = new RadioMenuItem("Background music");
        MenuItem cut = new MenuItem("Cut (ctrl+x)");
        MenuItem copy = new MenuItem("Copy (ctrl+c)");
        MenuItem paste = new MenuItem("Paste (ctrl+v)");
        MenuItem about = new MenuItem("About Lotto App");

        toggleGroup.getToggles().addAll(five, six, seven);
        menuSkill.getItems().addAll(five, six, seven);
        menuFile.getItems().addAll(musicItem, menuSkill);
        menuEdit.getItems().addAll(cut, copy, paste);
        menuAbout.getItems().add(about);
        
        bar.getMenus().addAll(menuFile, menuEdit, menuAbout);
        return bar;
    }

    public void resizeButton(ToggleButton b) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(200), b);
        scale.setByX(1.5f);
        scale.setByY(1.5f);
        scale.setCycleCount(2);
        scale.setAutoReverse(true);
        scale.play();
    }

    public void showVictoryDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("You won!");
        alert.showAndWait();
    }

    public void showLoseDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Loser!");
        alert.showAndWait();
    }

    public void doOnAction(ActionEvent e) {
        RotateTransition rotation = new RotateTransition(Duration.seconds(0.5), bottomButton);
        rotation.setCycleCount(1);
        rotation.setByAngle(360);
        if(!thread.isAlive()) {
            bottomButton.setText("I give up");
            rotation.play();
            thread = new Thread(this::count);
            thread.start();
        } else {
            bottomButton.setText("I'm feeling lucky");
            rotation.play();
            thread.interrupt();
            years = 0;
            changeButtonColorsToOriginal();
        }
    }

    public void chooseNumber(ActionEvent e) {
        ToggleButton b = (ToggleButton) e.getSource();
        int num = Integer.parseInt(b.getText());
        if(userChosenNumbers.contains(num)) {
            userChosenNumbers.remove(num);
            b.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 40% , white, yellow);");
        } else if(userChosenNumbers.size() < 7) {
            userChosenNumbers.add(num);
            resizeButton(b);
            b.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 40% , white, red);");
        } else {
            b.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 40% , white, yellow);");
        }
        if(userChosenNumbers.size() == 7) {
            bottomButton.setDisable(false);
        } else {
            bottomButton.setDisable(true);
        }
        topLabel.setText("You have chosen: " + userChosenNumbers);
    }

    public void changeButtonColor() {
        int count = 1;

        for(int y = 0; y < 6; y++) {
            for(int x = 0; x < 7; x++) {
                if(randomNumbers.contains(count)) {
                    for (Node node : gridPane.getChildren()) {
                        if(GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x) {
                            node.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 40% , white, gray);");
                            break;
                        }
                    }
                }
                count++;
            }
        }
    }

    public void changeButtonColorsToOriginal() {
        for (Node node : gridPane.getChildren()) {
            node.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 40% , white, yellow);");
        }
        int count = 1;
        for(int y = 0; y < 6; y++) {
            for(int x = 0; x < 7; x++) {
                if(userChosenNumbers.contains(count)) {
                    for (Node node : gridPane.getChildren()) {
                        if(GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x) {
                            node.setStyle("-fx-background-color: radial-gradient(center 50% 50% , radius 40% , white, red);");
                            break;
                        }
                    }
                }
                count++;
            }
        }
    }

    public void count() {
        boolean counting = true;
        long start = System.nanoTime();
        long startTotal = System.nanoTime();

        while(counting) {
            long timeInNanoSeconds = 100000000;
            long yearInterval = (getSliderValue() * getSliderValue()) * timeInNanoSeconds;
            long interval = yearInterval / 30;
            long elapsed = System.nanoTime() - start;
            long totalElapsed = System.nanoTime() - startTotal;

            if(interval < elapsed) {
                randomNumbers = createRandomNumbers();
                Platform.runLater(this::changeButtonColor);
                start = System.nanoTime();
            }
            if(yearInterval < totalElapsed) {
                startTotal = System.nanoTime();
                years++;
            }
            try {
                Thread.sleep(TimeUnit.MILLISECONDS.convert(interval, TimeUnit.NANOSECONDS));
            } catch (InterruptedException e) {
                Platform.runLater(this::showLoseDialog);
                return;
            }
            Platform.runLater(this::changeButtonColorsToOriginal);
            Platform.runLater(this::changeLabelText);

            if(isWin()) {
                counting = false;
                Platform.runLater(this::showVictoryDialog);
                return;
            }
        }
    }

    public boolean isWin() {
        return userChosenNumbers.equals(randomNumbers);
    }

    public void changeLabelText() {
        topLabel.setText(years + " years have passed.");
    }

}