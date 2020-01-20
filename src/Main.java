import guigen.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reference Application with JavaFX");



        ElementRecipe<GridPane> pane = new Vertical(null, Arrays.asList(
                // horizontal orientation
                new Horizontal(null, Arrays.asList(
                    // vertical orientation
                    new Vertical(null, Arrays.asList(
                            // labels
                            new Label("Label A"),
                            new Label("Label B")
                    )),

                    // vertical orientation
                    new Vertical(null, Arrays.asList(
                            // textfields
                            new Textfield("Textfielsd A"),
                            new Textfield("Textfield B")
                    ))
                )),


                // buttons
                new Button("Button A"),
                new Button("Button B"),

                // radio buttons
                new Radiobuttons(0, Arrays.asList(
                        "Choice A", "Choice B", "Choice C", "Choice D"
                )),

                // check boxes
                new Checkbox(true, "Checkbox A"),
                new Checkbox(false, "Checkbox B"),

                // alter: change background
                new AlterElement<>(new Label("Label with changed background"), label -> {
                    label.setBackground(new Background(new BackgroundFill(
                            new Color(1, 0, 0, 1), null, null)));
                    return label;}),

                new Positional(Arrays.asList(
                    new Position<>(10, 20, new Label("Label with changed position"))
                ))
        ));



        ElementRecipe<Pane> frame = new Container(Arrays.asList(pane));
        Pane generated = frame.build();

        Pane pane2 = new Pane();
        pane2.setPrefHeight(200);
        VBox vbox = new VBox(pane2, new javafx.scene.control.Label("Test"));

        primaryStage.setScene(new Scene(new FrameMainWindow().build(), 800, 600));
        //primaryStage.setScene(new Scene(new guigen.Radiobuttons.FrameMainWindow().build(), 400, 250));
        primaryStage.show();
    }
}