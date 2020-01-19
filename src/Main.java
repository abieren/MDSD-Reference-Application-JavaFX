import guigen.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reference Application with JavaFX");

        ElementRecipe<VBox> pane = new Vertical(Arrays.asList(
                // horizontal orientation
                new Horizontal(Arrays.asList(
                    // vertical orientation
                    new Vertical(Arrays.asList(
                            // labels
                            new Label("Label A"),
                            new Label("Label B")
                    )),

                    // vertical orientation
                    new Vertical(Arrays.asList(
                            // textfields
                            new TextField("Textfielsd A"),
                            new TextField("Textfield B")
                    ))
                )),

                // buttons
                new Button("Button A"),
                new Button("Button B"),

                // radio buttons
                new RadioButtons(0, Arrays.asList(
                        "Choice A", "Choice B", "Choice C", "Choice D"
                )),

                // check boxes
                new CheckBox(true, "Checkbox A"),
                new CheckBox(false, "Checkbox B"),

                // alter: change background
                new AlterElement<>(new Label("Label with changed background"), label -> {
                    label.setBackground(new Background(new BackgroundFill(
                            new Color(1, 0, 0, 1), null, null)));
                    return label;})
        ));

        ElementRecipe<Pane> frame = new Container(Arrays.asList(pane));

        primaryStage.setScene(new Scene(frame.build(), 400, 250));
        primaryStage.show();
    }
}