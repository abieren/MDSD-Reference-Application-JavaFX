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

                new Positional(Arrays.asList(
                    new Position<>(10, 20, new Label("Label with changed position"))
                ))
        ));

        ElementRecipe<Pane> frame = new Container(Arrays.asList(pane));
        Pane generated = frame.build();

        primaryStage.setScene(new Scene(generated, 800, 600));
        primaryStage.show();
    }
}